package com.simple.juc.mutitask.util.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-10 15:03
 **/
public class PhaserDemoOne {
    //因为有 CDE 三个线程作为控制条件，因此初值设为 3
    private static Phaser phaser = new Phaser(3);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("A begin");
            //动态增加一个参与的线程数，现在从 3 变成 4 了
            phaser.register();
            //在此阻塞
            phaser.arriveAndAwaitAdvance();
            //阻塞被唤醒后做自己的业务
            System.out.println("A end");
        }, "A").start();

        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " begin...");
            randomSleep();
            System.out.println(name + " end...");
            //作为控制条件的线程，则是所有工作完成后 arrive，不需要 awaitAdvance
            phaser.arrive();
        };

        new Thread(runnable, "C").start();

        //B 线程穿插在 CDE 线程中间跑
        new Thread(() -> {
            System.out.println("B begin");
            phaser.register();
            phaser.arriveAndAwaitAdvance();
            System.out.println("B end");
        }, "B").start();

        new Thread(runnable, "D").start();
        new Thread(runnable, "E").start();
    }

    private static void randomSleep() {
        Random random = new Random(System.currentTimeMillis());
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
