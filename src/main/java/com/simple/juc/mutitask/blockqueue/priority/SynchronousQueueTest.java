package com.simple.juc.mutitask.blockqueue.priority;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-06 14:37
 **/
@Slf4j
public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                log.info("入队列操作，添加元素1：===> 1, 当前线程：===> {}", Thread.currentThread().getName());
                synchronousQueue.put("1");
                TimeUnit.SECONDS.sleep(5);
                log.info("入队列操作，添加元素2：===> 2, 当前线程：===> {}", Thread.currentThread().getName());
                synchronousQueue.put("2");
                TimeUnit.SECONDS.sleep(5);
                log.info("入队列操作，添加元素3：===> 3, 当前线程：===> {}", Thread.currentThread().getName());
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                log.info("获取元素操作，获取的元素1：===> {}, 当前线程：===> {}", synchronousQueue.take(), Thread.currentThread().getName());
                log.info("获取元素操作，获取的元素2：===> {}, 当前线程：===> {}", synchronousQueue.take(), Thread.currentThread().getName());
                log.info("获取元素操作，获取的元素3：===> {}, 当前线程：===> {}", synchronousQueue.take(), Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
