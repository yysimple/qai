package com.simple.juc.studyinbook.principle.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-10-31 09:22
 **/
public class BlockingQueueTest {

    @Test
    public void testBlocking(){
        /**
         * 可以初始化队列大小， 且一旦初始化不能改变。构造方法中的fair表示控制对象的内部锁是否采用公平锁，默认是非公平锁
         */
        BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

        /**
         * 由链表结构组成的有界阻塞队列。内部结构是链表，具有链表的特性。默认队列的大小是Integer.MAX_VALUE，也可以指定大小。
         * 此队列按照先进先出的原则对元素进行排序。
         */
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);

        /**
         * 该队列中的元素只有当其指定的延迟时间到了，才能够从队列中获取到该元素 。注入其中的元素必须实现 java.util.concurrent.Delayed 接口。
         * DelayQueue是一个没有大小限制的队列，因此往队列中插入数据的操作（生产者）永远不会被阻塞，而只有获取数据的操作（消费者）才会被阻塞。
         */
        BlockingQueue delayQueue = new DelayQueue();

        /**
         * 基于优先级的无界阻塞队列（优先级的判断通过构造函数传入的Compator对象来决定），内部控制线程同步的锁采用的是非公平锁。
         */
        BlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();

        /**
         * 这个队列比较特殊，没有任何内部容量，甚至连一个队列的容量都没有。并且每个 put 必须等待一个 take，反之亦然。
         */
        BlockingQueue synchronousQueue = new SynchronousQueue();
    }
}
