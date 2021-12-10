package com.simple.juc.mutitask.util.semaphore;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * 功能描述: 自己实现信号锁
 *
 * @author: WuChengXing
 * @create: 2021-12-09 20:02
 **/
public class MySemaphore {

    private static long permitOffset;
    private static Unsafe unsafe;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            permitOffset = unsafe.objectFieldOffset(MySemaphore.class.getDeclaredField("permits"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 原子类更新
     *
     * @param expected
     * @param permit
     * @return
     */
    private boolean casUpdatePermit(int expected, int permit) {
        return unsafe.compareAndSwapInt(this, permitOffset, expected, permit);
    }

    /**
     * 信号量
     */
    private volatile int permits;

    /**
     * 使用线程安全的非阻塞队列，只是用来存放等待线程的，配合LockSupport实现阻塞
     */
    ConcurrentLinkedQueue<Thread> nThreadQueue;

    public MySemaphore(int permits) {
        this.permits = permits;
        this.nThreadQueue = new ConcurrentLinkedQueue<>();
    }

    /**
     * 阻塞获取锁的方法
     */
    public void acquire() throws InterruptedException {
        // 自旋尝试去获取锁
        for (; ; ) {
            // 可用资源
            int available = permits;
            // 如果资源不存在
            if (available < 1) {
                // 放入队列等待唤醒，并再次校验是否有可用资源，没有的话挂起线程
                // 阻塞当前线程，
                // 不必担心其它线程已经先从队列取出当前 thread 进行了 unpark，导致下面的 park 无限阻塞，
                // 如果 unpark 发生在 park 之前，被 unpark 的线程（如果已经 start）下一次 park 不会阻塞
                // 但还是要在 park 之前再检查一次，以免在当前线程放入队列之前，其它线程已经 release，错过唤醒导致永远阻塞
                if (nThreadQueue.offer(Thread.currentThread()) || permits < 1) {
                    LockSupport.park();
                }
                // 如果中途被唤醒，抛出异常
                if (Thread.interrupted()) {
                    // 如果是被 interrupt 叫醒的，抛出 InterruptedException
                    throw new InterruptedException();
                }
            } else if (casUpdatePermit(available, available - 1)) {
                break;
            }
        }
    }

    public void acquireUninterruptibly() {
        for (; ; ) {
            int available = permits;
            if (available < 0) {
                // 没有资源，然后加入队列，并且再次确定是否还有资源剩余，有的话，就再次循环，没有的话就挂起自己
                if (nThreadQueue.offer(Thread.currentThread()) || permits < 0) {
                    LockSupport.park();
                }
                // 相比 acquire 方法，只在这里有区别，这里不抛异常，仅设置 interrupt 状态
                if (Thread.interrupted()) {
                    Thread.currentThread().interrupt();
                }
            } else if (casUpdatePermit(available, available - 1)) {
                break;
            }
        }
    }

    public boolean tryAcquire() {
        for (; ; ) {
            int available = permits;
            if (available < 1) {
                return false;
            } else if (casUpdatePermit(available, available - 1)) {
                return true;
            }
        }
    }

    public void release() {
        for (; ; ) {
            int available = permits;
            // 释放资源成功后，唤醒队列的头节点
            if (casUpdatePermit(available, available + 1)) {
                Thread headThread = nThreadQueue.poll();
                if (headThread != null) {
                    LockSupport.unpark(headThread);
                }
                break;
            }
        }
    }
}
