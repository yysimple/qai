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
    public static void main(String[] args) {

    }

    public static final Integer START_NUM = 1;
    public static final Integer END_NUM = 100 * 10000;

    @Test
    public void testForkJoin() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        // 生成一个计算任务，负责计算 1~n
        CountTask counterForkJoin = new CountTask(START_NUM, END_NUM);
        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(counterForkJoin);
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

    private Integer countNum(Integer start, Integer end) {
        Integer res = 0;
        for (int i = start; i <= end; i++) {
            res += i;
        }
        return res;
    }
}
