package com.simple.juc.mutitask.util.countcownlatch;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 功能描述: 基于AQS实现
 *
 * @author: WuChengXing
 * @create: 2021-12-10 13:44
 **/
public class BaseAQSImplCDL {

    private static MySync sync;
    private static int count;

    public static int getCount() {
        return count;
    }

    public BaseAQSImplCDL(int count) {
        sync = new MySync(count);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    public void countDown() {
        sync.releaseShared(1);
    }

    static class MySync extends AbstractQueuedSynchronizer {

        public MySync(int num) {
            setState(num);
            count = getState();
        }

        @Override
        protected int tryAcquireShared(int arg) {
            // 这里实现其实很简单，只要当前状态不为0，就不给资源就行了
            return getState() == 0 ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                // 获取当前资源
                int state = getState();
                // 不需要释放
                if (state == 0) {
                    return false;
                }
                int remaining = state - arg;
                if (compareAndSetState(state, remaining)) {
                    return remaining == 0;
                }
            }
        }
    }
}
