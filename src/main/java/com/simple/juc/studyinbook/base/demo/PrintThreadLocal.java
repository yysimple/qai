package com.simple.juc.studyinbook.base.demo;

/**
 * @author WuChengXing
 * @date 2021/9/29
 */
public class PrintThreadLocal {
    static class ThreadA implements Runnable {
        private ThreadLocal<String> threadLocal;

        public ThreadA(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            int count = 0;
            while (count < 5) {
                count++;
                threadLocal.set("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadA输出：" + threadLocal.get());
            }

        }
    }

    static class ThreadB implements Runnable {
        private ThreadLocal<String> threadLocal;

        public ThreadB(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            int count = 0;
            while (count < 5) {
                count++;
                threadLocal.set("B");
                try {
                    Thread.sleep(1010);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadB输出：" + threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        new Thread(new ThreadA(threadLocal)).start();
        new Thread(new ThreadB(threadLocal)).start();
    }
}
