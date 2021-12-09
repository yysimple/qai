package com.simple.juc.mutitask.util.semaphore;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 功能描述: 基于AQS自己实现semaphore
 *
 * @author: WuChengXing
 * @create: 2021-12-09 21:40
 **/
public class BaseAQSSemaphore {

    private static MySync sync;

    public BaseAQSSemaphore(int permits) {
        sync = new MySync(2);
    }

    public boolean tryAcquire() {
        return sync.tryAcquireShared(1) >= 0;
    }

    public boolean release() {
        return sync.tryReleaseShared(1);
    }

    static class MySync extends AbstractQueuedSynchronizer {
        public MySync(int permits) {
            if (permits < 0) {
                throw new IllegalArgumentException("初始资源必须大于0");
            }
            setState(permits);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            // 自旋获取锁
            for (; ; ) {
                // 获取当前可用资源
                int available = getState();
                int remaining = available - arg;
                // 小于0的情况，资源不够了，也需要告诉AQS，让其去排队，等待唤醒
                // 原子交换成功的，也直接返回剩余量，自己获取锁成功
                if (remaining < 0 || compareAndSetState(available, remaining)) {
                    return remaining;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                // 依旧是先去获取剩余资源
                int available = getState();
                // 可用资源 + 需要释放的资源 = 新的剩余资源
                int remaining = available + arg;
                if (compareAndSetState(available, remaining)) {
                    return true;
                }

            }
        }

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
