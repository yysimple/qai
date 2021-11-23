package com.simple.juc.mutitask.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-23 22:46
 **/
public class MyShareLock implements Lock {

    private final static MySync mySync = new MySync(2);

    private static class MySync extends AbstractQueuedSynchronizer {
        protected MySync(int count) {
            if (count < 0) {
                throw new IllegalArgumentException("初始资源必须大于0");
            }
            // 放到资源池里面
            setState(count);
        }

        /**
         * 共享锁这里需要返回AQS一个值，大于等于 0 表示还有资源可以获取;
         * int r = tryAcquireShared(arg)
         * if (r >= 0){}
         * <p>
         * 所以这里实现起来也比较简单，自旋，先拿到当前还剩余多少，然后再减去当前需要获取的资源数量，然后相减
         * 这里如果是相减之后小于0，直接返回新值（小于0，外层AQS自己的实现会去自旋），然后原子交换值，交换成功则返回新值
         *
         * @param arg
         * @return
         */
        @Override
        protected int tryAcquireShared(int arg) {
            for (; ; ) {
                int current = getState();
                int newState = current - arg;
                // 这里如果是相减之后小于0，直接返回新值（小于0，外层AQS自己的实现会去自旋），然后原子交换值，交换成功则返回新值
                if (newState < 0 || compareAndSetState(current, newState)) {
                    return newState;
                }
            }
        }

        /**
         * 释放的接口就比较相似了，也是拿到当前资源数量，然后相加，直接进行原子修改就行了，然后返回true就行
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int current = getState();
                int newState = current + arg;
                if (compareAndSetState(current, newState)) {
                    return true;
                }
            }
        }

    }


    @Override
    public void lock() {
        mySync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        mySync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
