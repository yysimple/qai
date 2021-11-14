package com.simple.juc.studyinbook.principle;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-14 12:23
 **/
public class SynchronizedTest {

    public synchronized void testMethod() {

    }

    public synchronized static void testStaticMethod() {

    }

    public void testBlock() {
        synchronized (this) {

        }
    }
}
