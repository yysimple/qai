package com.simple.juc.studyinbook.principle;

/**
 * 再介绍一下volatile与普通变量的重排序规则:
 *  1. 如果第一个操作是volatile读，那无论第二个操作是什么，都不能重排序； 1read 2no
 *  2. 如果第二个操作是volatile写，那无论第一个操作是什么，都不能重排序； 2write 1no
 *  3. 如果第一个操作是volatile写，第二个操作是volatile读，那不能重排序。1write 2read 前后no
 *
 * @date 2021/10/22
 */
public class VolatileExample {
    // 声明普通变量
    int a = 0;
    // 声明volatile变量
    volatile boolean flag = false;

    // 以下两个变量的读操作是可以重排序的
    int i = a; // 普通变量读
    boolean j = flag; // volatile变量读

    public void writer() throws InterruptedException {
        a = 1; // step 1
        flag = true; // step 2
    }

    public void reader() throws InterruptedException {
        if (flag) { // step 3
            System.out.println(a); // step 4
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();

        new Thread(() -> {
            try {
                volatileExample.writer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-A").start();

        new Thread(() -> {
            try {
                volatileExample.reader();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-B").start();

    }
}
