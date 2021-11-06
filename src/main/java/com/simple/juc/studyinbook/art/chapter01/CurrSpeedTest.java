package com.simple.juc.studyinbook.art.chapter01;

import com.simple.util.BaseTest;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-06 15:33
 **/
public class CurrSpeedTest {
    private static final long count = 10000L;

    /**
     * 当并发执行累加操作不超过百万次时，速度会比串行执行累加
     * 操作要慢。那么，为什么并发执行的速度会比串行慢呢？这是因为线程有创建和上下文
     * 切换的开销。
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }

}
