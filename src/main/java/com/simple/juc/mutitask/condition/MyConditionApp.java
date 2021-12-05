package com.simple.juc.mutitask.condition;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-05 10:59
 **/
public class MyConditionApp {
    /**
     * 这里需要用java提供的队列来存储数据，或者自己实现的阻塞队列
     */
    private final int QUEUE_SIZE = 10;
    PriorityQueue<Integer> queue = new PriorityQueue<>(QUEUE_SIZE);

    /**
     * 定义Lock锁，和Condition对象
     */
    private Lock lock = new ReentrantLock();

    /**
     * 满条件
     */
    private Condition isFull = lock.newCondition();

    /**
     * 空条件
     */
    private Condition isEmpty = lock.newCondition();

    /**
     * 定义一个消费线程
     */
    class Consumer extends Thread {
        @Override
        public void run() {
            // 使用消费方法
            consume();
        }

        volatile boolean flag = true;

        private void consume() {
            // 模拟一直消费，没有就等待
            while (flag) {
                // 拿到lock锁进行消费
                lock.lock();
                try {
                    while (queue.isEmpty()) {
                        System.out.println("当前队列无可消费的数据，队列的大小");
                        // 空条件 进入等待，等待添加元素的那个线程 去告诉其 有元素可用，再次执行这里
                        isEmpty.await();
                    }
                    // 队列不为空，则开始消费元素
                    queue.poll();
                    System.out.println("消费元素，队列还剩余：" + queue.size() + "个元素");
                    // 告诉 满条件 ，我已经消费了，你可以继续塞元素了
                    isFull.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        }
    }

    /**
     * 定义一个生产线程
     */
    class Producer extends Thread {
        @Override
        public void run() {
            produce();
        }

        volatile boolean flag = true;

        private void produce() {
            // 这里一样是模拟循环，一直搁着生产
            while (flag) {
                lock.lock();
                try {
                    // 这里是再判断，当队列已经满了的操作
                    while (queue.size() == QUEUE_SIZE) {
                        System.out.println("队列已满，无法添加元素");
                        // 满条件 等待其他线程消费了元素 来唤醒当前条件
                        isFull.await();
                    }
                    // 这里生产元素
                    queue.offer(1);
                    System.out.println("生产元素，队列还可以继续生产：" + (QUEUE_SIZE - queue.size()) + "个元素");
                    // 然后告诉 空条件 你可以消费了
                    isEmpty.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyConditionApp app = new MyConditionApp();
        Producer producer = app.new Producer();
        Consumer consumer = app.new Consumer();
        producer.start();
        consumer.start();
        Thread.sleep(0);
        producer.interrupt();
        consumer.interrupt();
    }
}
