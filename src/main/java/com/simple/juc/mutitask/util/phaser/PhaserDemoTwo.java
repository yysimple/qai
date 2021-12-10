package com.simple.juc.mutitask.util.phaser;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Phaser;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-10 15:08
 **/
public class PhaserDemoTwo {
    private static Phaser phaser = new Phaser(2) {
        // 对应 CyclicBarrier 的 barrier action，
        // 但相比 Runnable 的无参，这里有两个参数，可以做一些额外的判断
        // 相同的是，也是在最后一个到达的线程执行
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            System.out.println("两个人打架打累了，休息一下...");
            return super.onAdvance(phase, registeredParties);
        }
    };

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": 打你一拳！！");
            phaser.arriveAndAwaitAdvance();
            System.out.println(name + ": 踢你一脚！！");
            phaser.arriveAndAwaitAdvance();

        };

        new Thread(runnable, "AAA").start();
        new Thread(runnable, "BBB").start();
    }
}
