package com.simple.juc;

/**
 * 功能描述: 死锁分析
 *
 * @author: WuChengXing
 * @create: 2022-02-20 19:54
 **/
public class DeckLockTest {
    public static void main(String[] args) {
        Object one = new Object();
        Object two = new Object();
        new Thread(() -> testDeckLock(one, two)).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> testDeckLock(two, one)).start();
    }

    public static void testDeckLock(Object one, Object two) {
        synchronized (one) {
            System.out.println("我拿到了第一把锁！！");
            try {
                Thread.sleep(1000);
                System.out.println("我准备来获取不同的锁！！");
                synchronized (two) {
                    System.out.println("我拿到了我对应的第二把锁！！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}