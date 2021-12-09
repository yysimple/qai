package com.simple.javabase.jihe;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-08 22:38
 **/
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        System.out.println(threadLocal.get());

        threadLocal.remove();
        System.out.println(threadLocal.get());

        ThreadLocal<Integer> share = new ThreadLocal<>();
        new Thread(() -> {
            share.set(111);
            System.out.println(Thread.currentThread().getName() + ": " + share.get());
        }, "AAA").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + share.get());
        }, "BBB").start();
    }
}
