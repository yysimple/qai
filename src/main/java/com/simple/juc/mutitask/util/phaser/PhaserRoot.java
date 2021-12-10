package com.simple.juc.mutitask.util.phaser;

import java.util.concurrent.Phaser;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-10 15:14
 **/
public class PhaserRoot {
    private static Phaser rootPhaser = new Phaser(2);
    private static Phaser phaser1 = new Phaser(rootPhaser, 1);
    private static Phaser phaser2 = new Phaser(phaser1, 1);
    private static Phaser phaser3 = new Phaser(phaser2, 1);

    /**
     * rootPhaser，phaser1，phaser2 调用 getRegisteredParties 方法得到的值都比构造方法中设的值多 1 个，而且也没有调用 register 方法，这就是上面总结的第一点；
     * phaser3 只有 1 个 parties，并且它自己已经 arrive 了，但它依然被阻塞在屏障处，因为它在等 phaser2 醒来，phaser2 在等 phaser1 醒来，phaser1 在等 rootPhaser 醒来，
     * 但 rootPhaser 因为还少一个 arrive 所以醒不来，导致所有线程都被阻塞着，只需把最后注释的一行代码打开就可以了；
     * 谁的 end 先打印出来是不确定的，因为 rootPhaser 会一下把在 phaser1，phaser2，phaser3 阻塞的线程全部唤醒。
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("root begin");
            System.out.println("root parties = " + rootPhaser.getRegisteredParties());
            System.out.println("root arrived parties = " + rootPhaser.getArrivedParties());
            rootPhaser.arriveAndAwaitAdvance();
            System.out.println("root end");
        }, "root").start();
        Thread.sleep(1000);
        new Thread(() -> {
            System.out.println("1 begin");
            System.out.println("phaser1 parties = " + phaser1.getRegisteredParties());
            System.out.println("phaser1 arrived parties = " + phaser1.getArrivedParties());
            phaser1.arriveAndAwaitAdvance();
            System.out.println("1 end");
        },"1").start();
        Thread.sleep(1000);
        new Thread(() -> {
            System.out.println("2 begin");
            System.out.println("phaser2 parties = " + phaser2.getRegisteredParties());
            System.out.println("phaser2 arrived parties = " + phaser2.getArrivedParties());
            phaser2.arriveAndAwaitAdvance();
            System.out.println("2 end");
        }, "2").start();
        Thread.sleep(1000);
        new Thread(() -> {
            System.out.println("3 begin");
            System.out.println("phaser3 parties = " + phaser3.getRegisteredParties());
            int arrive = phaser3.arrive();
            System.out.println("phaser3 arrived parties = " + phaser3.getArrivedParties());
            phaser3.awaitAdvance(arrive);
            System.out.println("3 end");
        }, "3").start();
        rootPhaser.arrive();
    }
}
