package com.simple.juc.demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-26 10:41
 **/
public class ThreadTestTicket {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }

    static class MyThread extends Thread {
        private AtomicInteger ticket = new AtomicInteger(5);

        @Override
        public void run() {
            while (true) {
                System.out.println("Thread ticket = " + ticket.decrementAndGet());
                if (ticket.intValue() < 0) {
                    break;
                }
            }
        }
    }
}
