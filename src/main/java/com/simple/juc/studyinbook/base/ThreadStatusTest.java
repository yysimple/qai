package com.simple.juc.studyinbook.base;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author WuChengXing
 * @date 2021/9/23
 */
public class ThreadStatusTest {

    @Test
    public void testStateNew() throws InterruptedException {
        Thread thread = new Thread(() -> {
        });
        System.out.println(thread.getState()); // 输出 NEW
    }

    @Test
    public void testStateRunning() throws InterruptedException {
        while (true) {
            Thread thread = new Thread(() -> {
            });
            thread.start();
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }
    }

    @Test
    public void testStateBlock() {
        // 用于争夺的锁
        final Object lock = new Object();
        Thread ta = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " invoke");
                try {
                    Thread.sleep(200001);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BLOCK-THREAD-A");

        Thread tb = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " invoke");
                try {
                    Thread.sleep(200001);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BLOCK-THREAD-B");
        ta.start();
        System.out.println("线程a: " + ta.getState());
        System.out.println("线程b: " + tb.getState());
        tb.start();
        System.out.println("after-线程a: " + ta.getState());
        System.out.println("after-线程b: " + tb.getState());
    }

    @Test
    public void testStateWaiting() {
        AtomicBoolean flag = new AtomicBoolean(true);
        while (flag.get()) {
            final Object lock = new Object();
            Thread threadA = new Thread(() -> {
                synchronized (lock) {
                    try {
                        lock.wait();
                        System.out.println("wait over");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "WAITING-Thread-A");
            Thread threadB = new Thread(() -> {
                synchronized (lock) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }, "WAITING-Thread-B");
            threadA.start();
            threadB.start();
        }
    }

    @Test
    public void blockedTest() throws InterruptedException {

        /**
         * 一是在测试方法blockedTest()内还有一个main线程
         * 二是启动线程后执行run方法还是需要消耗一定时间的。
         */
        Thread a = new Thread(this::testMethod, "a");
        Thread b = new Thread(this::testMethod, "b");

        /**
         * 测试方法的main线程只保证了a，b两个线程调用start()方法（转化为RUNNABLE状态），
         * 如果CPU执行效率高一点，还没等两个线程真正开始争夺锁，就已经打印此时两个线程的状态（RUNNABLE）了。
         * 当然，如果CPU执行效率低一点，其中某个线程也是可能打印出BLOCKED状态的（此时两个线程已经开始争夺锁了）
         */
        a.start();
        // Thread.sleep(1000L); // a:TERMINATED  // b:RUNNABLE or BLOCKED
        // a.join(); // a:TERMINATED  b:TIMED_WAITING or RUNNABLE
        b.start();


        System.out.println(a.getName() + ":" + a.getState()); // a:RUNNABLE
        System.out.println(b.getName() + ":" + b.getState()); // b:RUNNABLE
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
