package com.simple.juc.studyinbook.base.demo;

import lombok.SneakyThrows;

/**
 * @author WuChengXing
 * @date 2021/9/27
 */
public class PrintNotifyAndWaitDetail {

    public static class ThreadPrinter implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        private ThreadPrinter(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @SneakyThrows
        @Override
        public void run() {
            int count = 5;
            // 多线程并发，不能用if，必须使用whil循环
            while (count > 0) {
                // 先获取 prev 锁 // A -> C / B -> A / C -> B
                /**
                 * 情况分析：
                 *  1. 第一次分析：（跟线程启动的顺序有关）
                 *     - 因为启动是分先后顺序的，所以这里 A线程 占有C锁、A锁
                 *     - B线程应该去先持有 A锁，然后再持有B锁，这里就有个问题：
                 *          I.因为C线程是会去竞争B锁的，如果 A锁里面那个逻辑执行了很久，这个时候 B线程就会一直等待A锁去释放，这个时候B锁可能就被 C线程占据了
                 *          II.当C线程拿到了B锁，那么打印顺序就变了，A C B
                 *     - C线程按道理是拿到B锁，然后再拿C锁，所以就有刚刚的那种问题，他可能超前拿到了 B锁，导致B线程拿到A锁后，去获取B锁就需要等待，这个时候C就先打印了
                 *     这里的状态：假设A全部执行完，A线程在等待（只有被唤醒，自己不会再去竞争） C锁；B线程拿到了 A锁，B锁（正在执行，一个锁都没有释放）；C线程在等待 B锁释放；
                 *
                 *  2. B线程释放B锁和A锁：
                 *     - B线程就在等待唤醒，需要持有A线程的人去唤醒（只有A线程内存那个锁可以）
                 *     - B锁释放之后，C线程拿到B锁进入第一层，然后再拿到C锁（这里因为A线程持有的C锁wait了，只有等待唤醒，不会主动再次竞争）进入第二层
                 *
                 *  3. C线程唤醒所有的C锁持有者，然后再持有的B锁进入等待状态
                 *     - A线程被唤醒，拿到了C锁，又开始执行，然后又拿到自己的A锁（B线程持有的A锁已经在等待唤醒了），然后再唤醒A锁，在自己持有的C锁进入等待
                 *     - 然后接下来就是一样的逻辑
                 *
                 */
                synchronized (prev) {
                    // 再获取 self 锁 // A / B / C
                    synchronized (self) {
                        // 打印
                        System.out.println(name);
                        count--;
                        Thread.sleep(100);
                        // 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                        // System.out.println("当前线程：--" + name + "--, 开始通知下一个线程！");
                        // A 唤醒所有拿着 A锁的其他线程(B)
                        self.notifyAll();
                    }
                    Thread.sleep(1000);
                    // 此时执行完self的同步块，这时self锁才释放。
                    try {
                        // 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                        if (count == 0) {
                            // System.out.println("最后一次打印，唤醒所有线程！");
                            prev.notifyAll();
                        } else {
                            // 立即释放 prev锁，当前线程休眠，等待唤醒
                            System.out.println(name + "--,释放外层锁，prev，等待唤醒中！");
                            prev.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", c, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);

        new Thread(pa).start(); // C A
        // 保证初始ABC的启动顺序
        Thread.sleep(10);
        new Thread(pb).start(); // A B
        Thread.sleep(10);
        new Thread(pc).start(); // B C
        // Thread.sleep(10);
    }
}
