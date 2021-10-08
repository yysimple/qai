package com.simple.juc.studyinbook.principle;

/**
 * @author WuChengXing
 * @date 2021/10/8
 */
public class JmmTest {

    static Integer i = 0;

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            while (i < 100) {
                i++;
                System.out.println("thread-A: " + i);
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            while (i < 100) {
                i++;
                System.out.println("thread-B: " + i);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();

    }


}
