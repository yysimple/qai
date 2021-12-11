package com.simple.juc.mutitask.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 * FutureTask 的 7 种状态：
 *
 * NEW（0）：尚未执行，或正在执行；
 * COMPLETING（1）：执行完成，还没有保存结果；
 * NORMAL（2）：正常完成，已保存了任务执行的返回值；
 * EXCEPTIONAL（3）：异常退出，已保存了任务抛出的异常；
 * CANCELLED（4）：任务被取消，如果取消的时候，任务还没执行，不会再执行；如果正在执行，让其继续跑下去；
 * INTERRUPTING（5）：任务正在被取消，如果任务还没执行，不会再执行；如果正在执行，紧接着将其打断（任务是否响应这个打断是另外一回事）；
 * INTERRUPTED（6）：任务已被取消，如果取消的时候，任务还没执行，不会再执行；如果正在执行，那么此时任务已经被打断过了，任务有没有理会这个打断，FutureTask 无法得知。
 *
 * -----------------------------------------
 *
 * 状态变更的四种情况：
 *
 * 正常执行：NEW -> COMPLETING -> NORMAL；
 * 执行异常：NEW -> COMPLETING -> EXCEPTIONAL；
 * cancel(true) 成功：NEW -> INTERRUPTING -> INTERRUPTED；
 * cancel(false) 成功：NEW -> CANCELLED；
 * cancel(true/false) 失败：对任务执行没有任何影响，即前两种情况。
 *
 *
 *
 * @author: WuChengXing
 * @create: 2021-12-10 15:54
 **/
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunnableFuture<String> future = new FutureTask<>(() -> {
            System.out.println("run by thread: " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            return "success";
        });
        new Thread(future).start();
        long start = System.currentTimeMillis();
        String result = future.get();
        long end = System.currentTimeMillis();
        System.out.println("get result:" + result + ", cost:" + (end - start) + "ms");
    }
}
