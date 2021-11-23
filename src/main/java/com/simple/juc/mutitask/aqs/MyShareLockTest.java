package com.simple.juc.mutitask.aqs;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-23 22:59
 **/
public class MyShareLockTest {
    public static void main(String[] args) throws InterruptedException {
        final MyShareLock lock = new MyShareLock();
        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        // 启动 10 个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            // 设置成守护线程，所有线程都执行完了之后，jvm会退出
            w.setDaemon(true);
            w.start();
        }
        // 每隔 1 秒换行
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println();
        }

    }
}
