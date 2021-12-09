package com.simple.juc.mutitask.forkjoin;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-09 11:27
 **/
public class ForkJoinTaskDemo {

    public static final Long START_NUM = 1L;
    public static final Long END_NUM = 2000 * 10000L;

    @Test
    public void testForkJoin() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        // 生成一个计算任务，负责计算 1~n
        CountTask counterForkJoin = new CountTask(START_NUM, END_NUM);
        // 执行一个任务
        Future<Long> result = forkJoinPool.submit(counterForkJoin);
        try {
            System.out.println(result.get());
            long end = System.currentTimeMillis();
            System.out.println("总共耗时：" + (end - start));
            System.out.println(Runtime.getRuntime().availableProcessors());
        } catch (InterruptedException | ExecutionException ignored) {
        }
    }

    @Test
    public void testCount() {
        long start = System.currentTimeMillis();
        System.out.println(countNum(START_NUM, END_NUM));
        long end = System.currentTimeMillis();
        System.out.println("总共耗时：" + (end - start));
    }

    private Long countNum(Long start, Long end) {
        long res = 0L;
        for (Long i = start; i <= end; i++) {
            res += i;
        }
        return res;
    }
}
