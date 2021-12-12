package com.simple.juc.mutitask.threadpool.my;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-12 19:59
 **/
public class MyThreadPoolTest {
    public static void main(String[] args) {
        MyThreadPoolExecutor myThreadPoolExecutor
                = new MyThreadPoolExecutor(1,
                2,
                10,
                TimeUnit.SECONDS,
                null,
                null,
                null);
        myThreadPoolExecutor.execute(() -> {
            System.out.println("我是自己定义的线程池");
        });
        myThreadPoolExecutor.execute(() -> {
            System.out.println("我是自己定义的线程池");
        });
        myThreadPoolExecutor.execute(() -> {
            System.out.println("我是自己定义的线程池");
        });
    }
}
