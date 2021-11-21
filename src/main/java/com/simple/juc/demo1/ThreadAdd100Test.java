package com.simple.juc.demo1;

/**
 * 功能描述: 测试线程++一百次的结果
 *
 * @author: WuChengXing
 * @create: 2021-11-20 14:32
 **/
public class ThreadAdd100Test {
    static volatile int i = 0;

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int j = 0; j < 100; j++) {
                i++;
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread-print: " + i);
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
