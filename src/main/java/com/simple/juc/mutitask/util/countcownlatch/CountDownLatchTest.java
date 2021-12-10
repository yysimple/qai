package com.simple.juc.mutitask.util.countcownlatch;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-10 12:11
 **/
public class CountDownLatchTest {

    CountDownLatch count = new CountDownLatch(1);

    @Test
    public void testOne() throws InterruptedException {
        new Thread(() -> {
            System.out.println("3");
            count.countDown();
            System.out.println("2");
            count.countDown();
        }).start();
        count.await();
        System.out.println("1");
    }

    /**
     * CountDownLatch是只有--操作，没有++操作的，所以，当--到零的时候，就结束了；我们可以尝试让其有++的能力，通过反射就可以做到
     * CountDownLatch是基于AQS实现的，所以这里第一时间应该能想到使用的统计值应该是 AQS中的state，那就来试着修改
     */
    @Test
    public void updateCount() {
        new Thread(() -> {
            System.out.println("我再等待状态，只要有人--了我就能醒来！！");
            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我已经醒了，哈哈哈哈");
        }).start();
        try {
            // 拿到sync字段
            Field sync = CountDownLatch.class.getDeclaredField("sync");
            // 设置可以访问
            sync.setAccessible(true);
            // 反射获取 sync 变量值，是 AQS 的子类
            AbstractQueuedSynchronizer subAqs = (AbstractQueuedSynchronizer) sync.get(count);
            // 反射拿到 sync 变量类型的父类，即 AQS 的 state 变量
            Field state = subAqs.getClass().getSuperclass().getDeclaredField("state");
            // 修改该字段的值
            state.setAccessible(true);
            state.set(subAqs, 3);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("我初始化的时候只有 1 个开关，现在呢？ == " + count.getCount());
        count.countDown();
        System.out.println("我减一了，但是就是不叫醒你！！！");
    }
}
