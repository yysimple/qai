package com.simple.juc.studyinbook.base;

import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/9/23
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        /**
         * ThreadGroup是一个标准的向下引用的树状结构，这样设计的原因是防止"上级"线程被"下级"线程引用而无法有效地被GC回收。
         */
        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组名字：" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" +
                    Thread.currentThread().getName());
        });

        testThread.start();
        System.out.println("执行main所在线程的线程组名字： " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("执行main方法线程名字：" + Thread.currentThread().getName());
    }

    /**
     * 所以，如果某个线程优先级大于线程所在线程组的最大优先级，那么该线程的优先级将会失效，取而代之的是线程组的最大优先级。
     */
    @Test
    public void testThreadGroupPriority() {
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup, "thread");
        thread.setPriority(9);
        System.out.println("我是线程组的优先级" + threadGroup.getMaxPriority());
        System.out.println("我是线程的优先级" + thread.getPriority());
    }

    @Test
    public void copyThread() {
        Thread t1 = new Thread(() -> {
            System.out.println("testThread当前线程组名字：" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" +
                    Thread.currentThread().getName());
        });
        Thread t2 = new Thread(() -> {
            System.out.println("testThread当前线程组名字：" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" +
                    Thread.currentThread().getName());
        });

        // 获取当前的线程组
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        // 复制一个线程组到一个线程数组（获取Thread信息）
        Thread[] threads = new Thread[threadGroup.activeCount()];
        /*int enumerate1 = threadGroup.enumerate(threads);
        // 获取当前的线程组
        ThreadGroup threadGroup = new ThreadGroup();
        // 复制一个线程组到一个线程数组（获取Thread信息）
        Thread[] threads = new Thread[2];
        threads[0] = t1;
        threads[1] = t2;*/
        int enumerate = threadGroup.enumerate(threads);
        System.out.println("线程赋值的数量：" + enumerate);
        int i = threadGroup.activeCount();
        System.out.println("线程组的活动线程数：" + i);
    }

}
