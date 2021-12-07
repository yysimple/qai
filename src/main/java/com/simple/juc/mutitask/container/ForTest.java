package com.simple.juc.mutitask.container;

/**
 * 功能描述: '
 *
 * @author: WuChengXing
 * @create: 2021-12-07 14:43
 **/
public class ForTest {
    public static void main(String[] args) throws InterruptedException {
        int a = 0;
        int b = 0;
        for (int c = a, p = c; ; ) {
            System.out.println("c: " + c);
            System.out.println("p: " + p);
            a++;
            Thread.sleep(1000);
        }
    }
}
