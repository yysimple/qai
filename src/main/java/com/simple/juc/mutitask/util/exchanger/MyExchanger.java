package com.simple.juc.mutitask.util.exchanger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述: 自己实现线程之间的数据交换
 *
 * @author: WuChengXing
 * @create: 2021-12-10 11:09
 **/
public class MyExchanger<V> {

    /**
     * 拿到条件锁，用来控制并发和唤醒交换数据的线程
     */
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * 定义两个变量：一个用来存储当前是哪个线程；另外一个记录当前需要存储的数据
     */
    Object data;
    Thread prevThread;

    /**
     * 非延时交换器：
     * 1 条件循环：判断上一个线程存储是否为空 || 等于当前线程
     * 1.1 交换数据，把自己的数据存储，然后线程设置成自己的，然后进入等待
     * 1.2 被唤醒，再次做校验，如果现在的线程不是自己的，那就读取数据，然后将原有线程和数据置空（这里已经交换了一次，所以这里置空后直接返回）
     * 2 如果都不符合，证明不是第一次操作，直接读取数据，并且把自己的数据赋值，然后唤醒其他等待的线程，然后结束当前线程的此次交换
     *
     * @param val
     * @return
     * @throws InterruptedException
     */
    public V exchange(V val) throws InterruptedException {
        try {
            // 获取锁
            lock.lockInterruptibly();
            // 拿到当前线程,之后用来判断是否是当前线程
            Thread currThread = Thread.currentThread();
            while (prevThread == null || prevThread == currThread) {
                data = val;
                prevThread = currThread;
                // 等待唤醒
                condition.await();
                // 被唤醒后
                if (prevThread != currThread) {
                    Object v = data;
                    data = null;
                    prevThread = null;
                    return (V) v;
                }
            }
            // 都不符合，证明是获取数据的那方，就需要交换数据了
            Object v = data;
            data = val;
            prevThread = currThread;
            // 唤醒其他线程
            condition.signal();
            return (V) v;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 延时交换器的逻辑其实是差不多的，只是多了个超时检测
     * @param value
     * @param i
     * @param unit
     * @return
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public V exchange(V value, long i, TimeUnit unit) throws InterruptedException, TimeoutException {
        long remaining = TimeUnit.MILLISECONDS.convert(i, unit);
        long deadline = System.currentTimeMillis() + remaining;
        try {
            lock.lockInterruptibly();
            Thread currentThread = Thread.currentThread();
            while (prevThread == null || prevThread == currentThread) {
                data = value;
                prevThread = currentThread;
                condition.await(remaining, TimeUnit.MILLISECONDS);
                if (prevThread != currentThread) {
                    Object o = data;
                    data = null;
                    prevThread = null;
                    return (V) o;
                } else {
                    // 这里如果还是当前线程，会检测一次是否超时，其他的都一样
                    remaining = deadline - System.currentTimeMillis();
                    if (remaining <= 0) {
                        throw new TimeoutException();
                    }
                }
            }
            Object o = data;
            data = value;
            prevThread = currentThread;
            condition.signal();
            return (V) o;
        } finally {
            lock.unlock();
        }
    }

}
