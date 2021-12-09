package com.simple.juc.mutitask.forkjoin;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 功能描述: 计数器
 *
 * @author: WuChengXing
 * @create: 2021-12-09 11:28
 **/
@Slf4j
public class CounterForkJoin extends RecursiveTask<Integer> {
    private Integer startNum = 0;
    private Integer endNum = 0;
    private final Integer CPU_NUM = Runtime.getRuntime().availableProcessors();
    private Integer threshold = CPU_NUM;

    public CounterForkJoin(Integer startNum, Integer endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    public CounterForkJoin(Integer startNum, Integer endNum, Integer threshold) {
        this.startNum = startNum;
        this.endNum = endNum;
        this.threshold = threshold;
    }

    @Override
    protected Integer compute() {
        int res = 0;
        boolean canSplit = (endNum - startNum) > threshold;
        if (!canSplit) {
            for (int i = startNum; i <= endNum; i++) {
                res += i;
            }
        } else {
            List<ForkJoinTask<Integer>> forkJoinTasks = new ArrayList<>();
            int threadNum = (endNum - startNum) / threshold;
            if (threadNum > CPU_NUM) {
                threshold = CPU_NUM;
                int step = (endNum - startNum) / threshold;
                for (int i = 0; i < threshold; i++) {
                    endNum = startNum + step;
                    CounterForkJoin counterForkJoin = new CounterForkJoin(startNum, endNum, threshold);
                    log.info("当前线程：{}，{} + {}，阈值：{}", Thread.currentThread().getName(), startNum, endNum, threshold);
                    startNum = endNum + 1;
                    ForkJoinTask<Integer> fork = counterForkJoin.fork();
                    forkJoinTasks.add(fork);
                }
            } else {
                for (int i = 0; i < threshold; i++) {
                    CounterForkJoin counterForkJoin = new CounterForkJoin(startNum, endNum, threshold);
                    log.info("当前线程：{}，{} + {}，阈值：{}", Thread.currentThread().getName(), startNum, endNum, threshold);
                    startNum = endNum + 1;
                    ForkJoinTask<Integer> fork = counterForkJoin.fork();
                    forkJoinTasks.add(fork);
                }
            }

            for (ForkJoinTask<Integer> forkJoinTask : forkJoinTasks) {
                res += forkJoinTask.join();
            }
        }
        return res;
    }
}
