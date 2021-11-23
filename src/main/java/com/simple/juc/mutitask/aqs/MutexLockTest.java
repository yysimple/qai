package com.simple.juc.mutitask.aqs;

import java.util.Date;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-22 23:26
 **/
public class MutexLockTest {
    public static void main(String[] args) {
        MutexLock lock = new MutexLock();
        new Thread(() -> {
            lock.lock();
            try {
                Date now = new Date();
                System.out.println(" thread1 running now:" + now);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                Date now = new Date();
                System.out.println(" thread2 running now:" + now);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
