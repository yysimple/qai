package com.simple.juc.mutitask.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-09 12:20
 **/
public class CountTask extends RecursiveTask<Long> {

    /**
     * 阈值，这里可以思考下，如果是100w数据相加或者更大，阈值是大点好还是小点好？
     * 这里其实就是分段处理的 一片片的数据，举个例子，这里的阈值是10w，那么执行段就如下：
     * A：1~10W
     * B: 10W ~ 20W
     * C：...
     */
    private static final long THRESHOLD = 10 * 10000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        // 如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            long middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待子任务执行完，并得到其结果
            long leftResult = leftTask.join();
            long rightResult = rightTask.join();
            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }
}
