package com.simple.algorithm.test.demo;

/**
 * 功能描述: 线程打印
 *
 * @author: WuChengXing
 * @create: 2022-01-20 20:36
 **/
public class ThreadPrint {

    public static class PrintClazz implements Runnable {

        private String name;
        private Object self;
        private Object other;

        public PrintClazz(String name, Object self, Object other) {
            this.name = name;
            this.self = self;
            this.other = other;
        }

        @Override
        public void run() {
            int count = 5;
            try {
                while (count > 0) {
                    synchronized (other) {
                        synchronized (self) {
                            System.out.println("ThreadName: " + name);
                            count--;
                            self.notify();
                        }
                        if (count == 0) {
                            other.notify();
                        } else {
                            other.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Thread printThreadA = new Thread(new PrintClazz("A", a, c));
        Thread printThreadB = new Thread(new PrintClazz("B", b, a));
        Thread printThreadC = new Thread(new PrintClazz("C", c, b));
        printThreadA.start();
        Thread.sleep(20);
        printThreadB.start();
        Thread.sleep(20);
        printThreadC.start();
    }
}
