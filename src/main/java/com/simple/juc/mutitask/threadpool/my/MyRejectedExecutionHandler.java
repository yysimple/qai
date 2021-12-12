package com.simple.juc.mutitask.threadpool.my;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-12 18:10
 **/
public interface MyRejectedExecutionHandler {

    /**
     * 这里就是定义拒绝方法，然后传入执行的任务 + 对应的线程池
     * @param r
     * @param executor
     */
    void rejectedExecution(Runnable r, MyThreadPoolExecutor executor);
}
