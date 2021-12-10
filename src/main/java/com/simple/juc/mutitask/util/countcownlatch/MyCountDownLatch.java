package com.simple.juc.mutitask.util.countcownlatch;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * 功能描述: 自己实现一个数量减锁
 *
 * @author: WuChengXing
 * @create: 2021-12-10 13:39
 **/
public class MyCountDownLatch {

    /**
     * 使用java提供的原子类
     */
    private AtomicInteger atomicInteger;
    private ConcurrentLinkedQueue<Thread> queue;
    // 这个这里没有任何操作，只是为了兼容之前的测试类
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public MyCountDownLatch(Integer count) {
        if (count < 0) throw new IllegalArgumentException("count < 0");
        this.atomicInteger = new AtomicInteger(count);
        this.queue = new ConcurrentLinkedQueue<>();
    }

    /**
     * 实现等待很简单：
     * 1. 首先线程进来判断资源是否 == 0；不等的话进行加入队列操作，并且挂起自己
     * 2. 如果不等，且中途被中断，抛出中断异常
     * 3. 安稳等待其他线程唤醒即可
     */
    public void await() throws InterruptedException {
        while (atomicInteger.get() != 0) {
            Thread currentThread = Thread.currentThread();
            if (queue.offer(currentThread) && atomicInteger.get() != 0) {
                LockSupport.park();
            }

            if (currentThread.isInterrupted()) {
                throw new InterruptedException();
            }
        }
    }

    /**
     * 实现唤醒：
     * 1. 首先每次进行原子减一操作，成功之后，判断状态是否为 0，是那就进行唤醒操作
     * 2. 唤醒操作这里有一点特殊，就是需要一次性唤醒队列中的所有线程
     */
    public void countDown() {
        if (atomicInteger.get() == 0) {
            return;
        }

        if (atomicInteger.decrementAndGet() == 0) {
            Thread t;
            while ((t = queue.poll()) != null) {
                LockSupport.unpark(t);
            }
        }
    }
}
