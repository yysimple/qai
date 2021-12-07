package com.simple.juc.mutitask.container;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 功能描述: 非阻塞队列测试
 *
 * @author: WuChengXing
 * @create: 2021-12-07 11:10
 **/
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("A");
        System.out.println(queue);
        queue.offer("B");
        queue.offer("C");
        // 出队列
        queue.poll();
        queue.poll();
        queue.poll();
        queue.offer("D");
        System.out.println("==== 结束 ====");
    }
}
