package com.simple.juc.mutitask.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @date 2021/11/23
 * 1. 定义一个锁，继承Lock,算是一个统一的规范
 * 2. 定义Sync类，随便叫啥也可以，这里叫 ==MySync==,去继承AQS，然后实现其中的方法
 */
public class MyMutexLock implements Lock {

    private static final MySync mySync = new MySync();

    /**
     * 自己定义一个获取锁的同步逻辑
     */
    public static class MySync extends AbstractQueuedSynchronizer {
        public MySync() {
        }

        /**
         * 尝试获取锁，这里很简单，只要拿到状态资源，就像state设置成 1 即可
         * 这个方法主要是给AQS里面的acquire去使用的；
         * 1. 这里参数无需使用，独占式情况下，进行原子替换即可
         * 2. 拿到锁之后，将独占的标识设置成对应的线程，然后返回true，标识已经拿到资源
         * 3. 通过在 lock方法中调用acquire方法，就会调用这个方法
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            // 独占式实现不需要参数，但是规范还是要有的
            if (compareAndSetState(0, 1)) {
                // 占有当前资源，标记成是自己占用
                setExclusiveOwnerThread(Thread.currentThread());
                // 返回true，标识已经拿到资源
                return true;
            }
            return false;
        }

        /**
         * 解锁，也可以说是释放资源，这里的话操作也很简单
         * 因为是独占的原因，所以不需要原子操作，因为当前资源只能被当前线程持有
         * 所以先判断状态是否是持有锁的状态，不是则抛出异常，是的话就将state设置成0并将占有状态清空
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }

    /**
     * 这里去对外暴露的方法，也就是提供给外部使用的方法；
     * 这路的acquire是调用AQS的方法，具体的实现AQS已经完成
     * 所以这里自定义度很高
     */
    @Override
    public void lock() {
        mySync.acquire(1);
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
        return  mySync.tryAcquireNanos(1, unit.toNanos(time));
    }

    /**
     * 独占式释放锁的逻辑比较简单
     */
    @Override
    public void unlock() {
        mySync.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
