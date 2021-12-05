package com.simple.juc.mutitask.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-05 11:37
 **/
public class BoundedQueue<T> {
    /**
     * 定义空数组和操作索引,和元素个数
     */
    private Object[] items;
    private Integer addIndex, removeIndex, count;

    /**
     * 定义锁和条件锁
     */
    private Lock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();

    /**
     * 初始化队列
     *
     * @param size
     */
    public BoundedQueue(int size) {
        this.items = new Object[size];
        this.removeIndex = 0;
        this.addIndex = 0;
        this.count = 0;
    }

    /**
     * 往队尾添加元素
     *
     * @param elem
     */
    public void add(T elem) {
        // 先拿到锁
        lock.lock();
        try {
            // 当数组已经存满了，那就等待消费过后才允许其添加，当前就阻塞再此
            while (count == items.length) {
                isFull.await();
            }
            // 加入元素
            items[addIndex] = elem;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            ++count;
            // 通知消费线程有元素了
            isEmpty.signal();
            System.out.println("add - 当前队列元素个数：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 删除头部元素
     */
    @SuppressWarnings("unchecked")
    public T removeFromHead() {
        lock.lock();
        try {
            // 对列中没有数据，则等待生产者生产数据，自己阻塞
            while (count == 0) {
                isEmpty.wait();
            }
            Object x = items[removeIndex];
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            --count;
            // 通知消费者，现在已经可以生产元素了，我这边已经消费了
            isFull.signal();
            System.out.println("remove - 当前队列元素个数：" + count);
            return (T) x;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }


}
