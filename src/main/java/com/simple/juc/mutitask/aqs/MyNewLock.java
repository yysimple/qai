package com.simple.juc.mutitask.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @date 2021/11/23
 * 1. 定义一个锁，继承Lock,算是一个统一的规范
 * 2. 定义Sync类，随便叫啥也可以，这里叫 ==MySync==
 */
public class MyNewLock implements Lock {

    private final static MySync mySync = new MySync()


    @Override
    public void lock() {
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

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
