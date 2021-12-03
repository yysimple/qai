package com.simple.juc.mutitask.reentrant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述: reentrantLock的性能测试
 *
 * @author: WuChengXing
 * @create: 2021-12-02 23:46
 **/
public class ReentrantLockSpeedTest {

        private static Sync fairLock = new Sync(true);
        private static Sync noFairLock = new Sync(false);

        public static void testLock(Sync lock) {
            // 开启5个线程
            for (int i = 0; i < 5; i++) {
                new Thread(new Job(lock), String.valueOf(i)).start();
            }
        }

        private static class Job extends Thread {
            private Sync lock;
            public Job(Sync lock) {
                this.lock = lock;
            }

            public void run() {
                for (int i = 0; i < 2; i++) {
                    lock.lock();
                    // 这里打印线程名 + 最后的等待队列
                    System.out.println("locked by " + currentThread().getName() + ", waiting by " + lock.getQueueThreads());
                    lock.unlock();
                }
            }
        }

    /**
     * 这里定义一个sync同步器去继承ReentrantLock，然后通过使用父类构造器传入对应的公平或者非公平的标识
     */
    private static class Sync extends ReentrantLock {
            public Sync(boolean fair) {
                super(fair);
            }

            /**
             * 获取等待队列
             * @return
             */
            public List<String> getQueueThreads() {
                List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
                Collections.reverse(arrayList);
                List<String> list = new ArrayList<>();
                arrayList.forEach(el -> list.add(el.getName()));
                return list;
            }
        }

        public static void main(String[] args) {
//             testLock(fairLock);
             testLock(noFairLock);
        }

}
