package com.simple.algorithm.mianshi;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 功能描述: 并发生成三个随机数，然后求平均值
 *
 * @author: WuChengXing
 * @create: 2022-02-16 19:41
 **/
public class AliDemo {

    public static void main(String[] args) {
        int threads = 3;
        CountDownLatch latch = new CountDownLatch(threads);
        Random random = new Random(100);
        for (int i = 0; i < 3; i++) {
            final Thread thread = new Thread(new RandomTask(random, i, 3, latch));
            thread.start();
        }
    }

    public static Integer createRandom() {
        return null;
    }
}

class RandomTask implements Runnable {

    private final Random rmd;
    private final int id;
    protected final long count;
    private final CountDownLatch latch;

    public RandomTask(Random rmd, int id, long count, CountDownLatch latch) {
        this.rmd = rmd;
        this.id = id;
        this.count = count;
        this.latch = latch;
    }

    protected Random getRandom() {
        return rmd;
    }

    @Override
    public void run() {
        try {
            final Random r = getRandom();
            latch.countDown();
            latch.await();
            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += r.nextInt();
            }
            System.out.println(sum / 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
