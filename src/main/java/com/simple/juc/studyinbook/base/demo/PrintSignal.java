package com.simple.juc.studyinbook.base.demo;

import lombok.SneakyThrows;

/**
 * @author WuChengXing
 * @date 2021/9/28
 */
public class PrintSignal {

    private static volatile int signal = 1;

    static class ThreadA implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            while (signal < 1000) {
                if (signal % 3 == 1) {
                    System.out.println("A-线程,signal=" + signal);
                    signal++;
                }
                Thread.sleep(500);
                System.out.println("--------");
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            while (signal < 1000) {
                if (signal % 3 == 2) {
                    System.out.println("B-线程,signal=" + signal);
                    signal++;
                }
            }
        }
    }

    static class ThreadC implements Runnable {

        @Override
        public void run() {
            while (signal < 1000) {
                if (signal % 3 == 0) {
                    System.out.println("C-线程,signal=" + signal);
                    signal++;
                }
            }
        }
    }

    /**
     * 这里很简单，
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
//        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
//        Thread.sleep(1000);
        new Thread(new ThreadC()).start();
    }
}
