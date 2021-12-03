package com.simple.juc.mutitask.reentrant;

/**
 * 功能描述: 自己实现简单的读写锁
 *
 * @author: WuChengXing
 * @create: 2021-12-03 22:06
 **/
public class MyReadWriteLock {

    /**
     * 定义一个state状态,用来表示获取状态
     */
    private volatile int state = 0;

    /**
     * 获取读锁状态
     *
     * @return
     */
    private int getReadState() {
        return state >>> 16;
    }

    /**
     * 获取写锁状态
     *
     * @return
     */
    private int getWriteState() {
        return state & ((1 << 16) - 1);
    }

    /**
     * 获取读锁,这里用 synchronized 来帮助完成 读锁锁定
     * 这里只是简单的,不知道 公平\非公平
     * 只是实现与写锁互斥
     */
    public synchronized void readLock() {
        // 目前存在写锁,读请求等待
        while (getWriteState() > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Thread: 获取到读锁");
        state = state + (1 << 16);
    }

    /**
     * 释放锁
     */
    public synchronized void readUnLock() {
        state = state - ((1 << 16));
        notifyAll();
    }

    /**
     * 获取写锁:同样是写写互斥,读写互斥
     */
    public synchronized void writeLock() {
        while (getReadState() > 0 || getWriteState() > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Thread: 获取到写锁");
        state++;
    }

    /**
     * 释放写锁数量减1，通知所有等待线程
     */
    public synchronized void writeUnLock() {
        state--;
        notifyAll();
    }
}
