package com.simple.juc.studyinbook.base.demo;

/**
 * @author WuChengXing
 * @date 2021/9/27
 */
public class ThreadPrint {

    public static class ThreadPrinter implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        private ThreadPrinter(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            // 多线程并发，不能用if，必须使用whil循环
            while (count > 0) {
                // 先获取 prev 锁
                synchronized (prev) {
                    // 再获取 self 锁
                    synchronized (self) {
                        // 打印
                        System.out.println(name);
                        count--;
                        // 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                        self.notifyAll();
                    }
                    // 此时执行完self的同步块，这时self锁才释放。
                    try {
                        // 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                        if (count == 0) {
                            prev.notifyAll();
                        } else {
                            // 立即释放 prev锁，当前线程休眠，等待唤醒
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

        new Thread(pa).start();
        Thread.sleep(10);// 保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
    }
}
