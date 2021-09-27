package com.simple.juc.studyinbook.base;

/**
 * @author WuChengXing
 * @date 2021/9/26
 */
public class WaitAndNotify {
    private static Object lock = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 5; i++) {
                    try {
                        System.out.println("ThreadA: " + i);
                        lock.notify();
                        Thread.sleep(1000);
                        System.out.println("A 通知 B");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("释放所有的锁");
                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 5; i++) {
                    try {
                        System.out.println("ThreadB: " + i);
                        lock.notify();
                        Thread.sleep(1000);
                        System.out.println("B 通知 A");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("释放所有的锁");
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }
}
