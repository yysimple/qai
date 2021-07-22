package com.simple.javabase.test;

/**
 * @author WuChengXing
 * @date 2021/7/22
 */
public class RefAddressTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        testSwapAddress(a, b);
        System.out.println("a = " + a + " , " + "b = " + b);

    }

    public static void testSwapAddress(int c, int d) {
        int tmp;
        tmp = c;
        c = d;
        d = tmp;
    }
}
