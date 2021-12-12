package com.simple.juc.mutitask.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-12 12:31
 **/
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor
                = new ThreadPoolExecutor(1,
                2,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(1));

        threadPoolExecutor.submit(() -> {
            System.out.println("你好啊，我是submit方法！！我是没有返回的呢！！");
            sleep(10000);
        });

        threadPoolExecutor.execute(() -> {
            System.out.println("你好啊，我是execute方法！！我是可以有返回的！！");
            sleep(10000);
        });

        threadPoolExecutor.execute(() -> {
            System.out.println("你好啊，我是execute方法！！我是可以有返回的！！");
            sleep(10000);
        });

        threadPoolExecutor.execute(() -> {
            System.out.println("你好啊，我是execute方法！！我是可以有返回的！！");
            sleep(10000);
        });
    }

    static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
