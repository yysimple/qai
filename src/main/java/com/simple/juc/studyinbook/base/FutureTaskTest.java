package com.simple.juc.studyinbook.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author WuChengXing
 * @date 2021/9/23
 */
public class FutureTaskTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        // 模拟计算需要一秒
        Thread.sleep(3000);
        return 2;
    }

    public static void main(String args[]) throws Exception {
        // 使用
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new FutureTaskTest());
        // 无返回，相较于之前返回Future，这里是 futureTask 在提交任务之后，可以去获取返回值
        // 这里传的实际上是 Runnable接口，前者是 Callable
        executor.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
