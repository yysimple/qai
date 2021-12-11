package com.simple.juc.mutitask.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-10 17:19
 **/
public class CompletionServiceDemo {
    private static Executor executor = Executors.newFixedThreadPool(10);
    private static ExecutorCompletionService<Integer> ecs = new ExecutorCompletionService<>(executor);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //new 出 10 个 Callable
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            tasks.add(() -> {
                TimeUnit.SECONDS.sleep(10 - finalI);
                return finalI;
            });
        }

        //不用 CompletionService，统计耗时
//        getAndProcessResultByFutureGet(tasks);
        //用 CompletionService，统计耗时
        getAndProcessResultByCompletionService(tasks);
    }

    private static void getAndProcessResultByFutureGet(List<Callable<Integer>> tasks) throws ExecutionException, InterruptedException {
        //提交所有任务
        List<FutureTask<Integer>> futureTasks = new ArrayList<>();
        for (Callable<Integer> task : tasks) {
            FutureTask<Integer> futureTask = new FutureTask<>(task);
            futureTasks.add(futureTask);
            // 批量执行任务
            executor.execute(futureTask);
        }

        //统计等待所有任务执行完成，并处理完所有结果的耗时
        long start = System.currentTimeMillis();
        for (FutureTask<Integer> futureTask : futureTasks) {
            int result = futureTask.get();
            processResult(result);
        }
        long end = System.currentTimeMillis();
        System.out.println("all result processed, cost " + (end - start) + " ms");
    }

    private static void getAndProcessResultByCompletionService(List<Callable<Integer>> tasks) throws InterruptedException, ExecutionException {
        //提交所有任务
        for (Callable<Integer> task : tasks) {
            ecs.submit(task);
        }

        //统计等待所有任务执行完成，并处理完所有结果的耗时
        long start = System.currentTimeMillis();
        int taskSize = tasks.size();
        int count = 0;
        while (true) {
            Future<Integer> future = ecs.take();
            processResult(future.get());
            count++;
            if (count == 10) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("all result processed by ecs, cost " + (end - start) + " ms");
    }

    private static void processResult(int result) throws InterruptedException {
        //处理每个任务的结果耗时 1 秒
        TimeUnit.SECONDS.sleep(1);
        System.out.println("processed result:" + result);
    }
}
