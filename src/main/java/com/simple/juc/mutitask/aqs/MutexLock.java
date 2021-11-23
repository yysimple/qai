package com.simple.juc.mutitask.aqs;


import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-22 23:23
 **/
public class MutexLock implements Lock, Serializable {

    private static final Sync sync = new Sync();

    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean isHeldExclusively() {
            if (getState() == 1) {
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;
            /*此处使用原子操作是为了确保并发时只有一个线程成功获取同步状态，
             *直接采用先getState方法后setState会有问题
             */
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            if (getState() == 1) {
                setState(0);
                setExclusiveOwnerThread(null);
                return true;
            }
            return false;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        // 获取锁资源，这里只是触发了AQS的操作
        sync.acquire(1);
    }

    @Override
    public boolean tryLock() {
        // 这里是子类提供获取资源的判断，会存在原子交换，获取到了就将state置为1，且返回true，表示获取到资源
        return sync.tryAcquire(1);
    }

    @Override
    public void unlock() {
        // 释放锁的操作依旧由AQS提供，释放成供其底层会去触发唤醒其他线程的操作
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }
}
