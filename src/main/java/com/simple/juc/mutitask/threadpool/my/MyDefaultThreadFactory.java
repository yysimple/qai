package com.simple.juc.mutitask.threadpool.my;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-12 18:13
 **/
public class MyDefaultThreadFactory implements ThreadFactory {

    /**
     * 线程数量
     */
    private AtomicInteger threadNum;

    /**
     * 线程对应的前缀名称
     */
    private String threadNamePrefix;

    /**
     * 线程组
     */
    private ThreadGroup threadGroup;

    public MyDefaultThreadFactory() {
        // 线程唯一表示，默认为 1，如果需要新的自增，使用原子自增
        this.threadNum = new AtomicInteger(1);
        // 自己定义自己的线程池名称前缀
        this.threadNamePrefix = "my-pool-thread-";
        // 获取当前线程的线程组
        this.threadGroup = Thread.currentThread().getThreadGroup();
    }

    /**
     * 这里简单的按照自己的命名方式去创建新的线程
     * 线程工厂的主要目的是统一管理线程池里面的线程。
     *
     * @param r
     * @return
     */
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(threadGroup, r, threadNamePrefix + threadNum.getAndIncrement());
    }
}
