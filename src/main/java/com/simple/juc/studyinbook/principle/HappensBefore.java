package com.simple.juc.studyinbook.principle;

/**
 * @author WuChengXing
 * @date 2021/10/9
 */
public class HappensBefore {

    private void testTagAndSeek(int a, int b, int c, int d, int e, int f) {
        a = b + c;
        d = e - f;
    }
}
