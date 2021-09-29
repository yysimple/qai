package com.simple.juc.studyinbook.base;

/**
 * @author WuChengXing
 * @date 2021/9/29
 */
public class JoinTest {
    static class ThreadA implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("我是子线程，我先睡一秒");
                Thread.sleep(1000);
                System.out.println("我是子线程，我睡完了一秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadA());
        thread.start();
        //thread.join();
        System.out.println("如果不加join方法，我会先被打出来，加了就不一样了");
    }
}
