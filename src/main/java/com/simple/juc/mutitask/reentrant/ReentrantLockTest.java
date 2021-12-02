package com.simple.juc.mutitask.reentrant;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-30 23:42
 **/
public class ReentrantLockTest {

    static int size = 0;
    static ReentrantLock reentrantLock = new ReentrantLock();

    @Test
    public void test() {

    }

    @Test
    public void testLock() {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        m1.start();
        m2.start();
    }

    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        m1.start();
        m2.start();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            reentrantLock.lock();
            for (int i = 0; i < 100; i++) {
                size++;
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName() + ":" + size);
        }
    }
}
