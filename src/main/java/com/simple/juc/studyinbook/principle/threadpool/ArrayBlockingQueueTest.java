package com.simple.juc.studyinbook.principle.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-10-31 18:09
 **/
public class ArrayBlockingQueueTest {

    int queueSize = 10;
    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(queueSize);

    @Test
    public void test() {
        Producer producer = new ArrayBlockingQueueTest.Producer();
        Consumer consumer = new ArrayBlockingQueueTest.Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            consumer();
        }

        public void consumer() {
            while (true) {
                try {
                    blockingQueue.take();
                    System.out.println("取走一个值，剩余：" + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }

        public void producer() {
            while (true) {
                try {
                    blockingQueue.put(1);
                    System.out.println("存入一个元素，剩余可用空间：" + (queueSize - blockingQueue.size()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
