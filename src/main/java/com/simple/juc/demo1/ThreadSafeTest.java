package com.simple.juc.demo1;

import java.util.concurrent.*;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: 线程安全测试
 *
 * @author: WuChengXing
 * @create: 2021-03-25 13:26
 **/
public class ThreadSafeTest {

    public static void main(String[] args) {
        Student student = new Student("aa", 18);
        Thread a = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                    student.setAge(student.getAge() + i);
                    System.out.println(student.getAge());
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(student);
            }
        });

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                10,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<Void> a1 = CompletableFuture.runAsync(a::start, threadPoolExecutor);

        CompletableFuture<Void> b1 = CompletableFuture.runAsync(b::start, threadPoolExecutor);

        CompletableFuture.allOf(a1, b1);

    }
}
