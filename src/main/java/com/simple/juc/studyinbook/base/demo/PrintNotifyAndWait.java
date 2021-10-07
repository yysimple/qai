package com.simple.juc.studyinbook.base.demo;

/**
 * @author WuChengXing
 * @date 2021/9/28
 */
public class PrintNotifyAndWait {
    public static class PrintThread implements Runnable {
        private String threadName;
        private Object pre;
        private Object self;

        public PrintThread(String threadName, Object pre, Object self) {
            this.threadName = threadName;
            this.pre = pre;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 5;
            while (count > 0) {
                try {
                    synchronized (pre) {
                        synchronized (self) {
                            System.out.println(threadName + "-线程");
                            count--;
                            self.notify();
                        }
                        if (count == 0) {
                            pre.notify();
                        } else {
                            pre.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        PrintThread pta = new PrintThread("A", c, a);
        PrintThread ptb = new PrintThread("B", a, b);
        PrintThread ptc = new PrintThread("C", b, c);

        new Thread(pta).start();
        Thread.sleep(10);
        new Thread(ptb).start();
        Thread.sleep(10);
        new Thread(ptc).start();
    }
}
