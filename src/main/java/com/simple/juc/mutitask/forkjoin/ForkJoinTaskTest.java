package com.simple.juc.mutitask.forkjoin;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-09 11:26
 **/
public class ForkJoinTaskTest {
    public static void main(String[] args) {
        ForkJoinTask<Integer> forkJoinTask = new RecursiveTask<Integer>() {
            @Override
            protected Integer compute() {
                return null;
            }
        };
    }
}
