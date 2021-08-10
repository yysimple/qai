package com.simple.juc.demo1;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-26 10:44
 **/
public class RunnableTestTicket {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2).start();
        new Thread(myThread2).start();
    }

    static class MyThread2 implements Runnable {

        private int ticket = 5;

        @Override
        public void run() {
            while (true) {
                System.out.println("Thread ticket = " + ticket--);
                if (ticket < 0) {
                    break;
                }
            }
        }
    }
}
