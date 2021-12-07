package com.simple.juc.mutitask.blockqueue;

import java.util.concurrent.*;

/**
 * 功能描述: 阻塞队列的实现
 *
 * @author: WuChengXing
 * @create: 2021-12-05 17:47
 **/
public class BlockQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        DelayQueue delayQueue = new DelayQueue();
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
    }
}
