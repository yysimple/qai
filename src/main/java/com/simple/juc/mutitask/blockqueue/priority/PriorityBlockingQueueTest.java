package com.simple.juc.mutitask.blockqueue.priority;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-06 12:38
 **/
public class PriorityBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Student> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityBlockingQueue.put(new Student("小三", 15));
        priorityBlockingQueue.put(new Student("小久", 25));
        priorityBlockingQueue.put(new Student("大时", 18));
        priorityBlockingQueue.put(new Student("小行", 19));
        priorityBlockingQueue.put(new Student("小慢", 9));

        for (;;){
            System.out.println(priorityBlockingQueue.take().toString());
        }
    }
}
