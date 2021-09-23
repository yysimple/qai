package com.simple.juc.studyinbook.base;

import com.simple.util.BaseTest;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author WuChengXing
 * @date 2021/9/23
 */
public class ThreadPriorityTest extends BaseTest {

    /**
     * Java中线程优先级可以指定，范围是1~10。
     * 但是并不是所有的操作系统都支持10级优先级的划分（比如有些操作系统只支持3级划分：低，中，高），
     * Java只是给操作系统一个优先级的参考值，线程最终在操作系统的优先级是多少还是由操作系统决定
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread a = new Thread();
        System.out.println("我是默认线程优先级：" + a.getPriority());
        Thread b = new Thread();
        b.setPriority(10);
        System.out.println("我是设置过的线程优先级：" + b.getPriority());
        // -----------
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
        T1 t1 = new T1();
        t1.setName("单独设置的线程优先级10");
        t1.setPriority(10);
        t1.start();

        /**
         * 只能将非活动线程设置成守护线程，否则会抛出异常：IllegalThreadStateException
         */
        T2 t2 = new T2();
        t2.setName("我是守护线程");
        t2.setDaemon(true);
        t2.start();
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是：%s，优先级：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是：%s，优先级：%d，是否是守护线程：%b",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority(), Thread.currentThread().isDaemon())
            );
        }
    }
}
