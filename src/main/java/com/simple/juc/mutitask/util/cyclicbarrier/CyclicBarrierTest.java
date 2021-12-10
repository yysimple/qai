package com.simple.juc.mutitask.util.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 功能描述: 循环屏障测试
 *
 * @author: WuChengXing
 * @create: 2021-12-10 14:36
 **/
public class CyclicBarrierTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
        System.out.println("两个人打架打累了，休息一下");
    });

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": 打你一拳！！");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + ": 踢你一脚！！");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        };

        new Thread(runnable, "AAA").start();
        new Thread(runnable, "BBB").start();
    }
}
