package com.simple.juc.mutitask.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-09 18:18
 **/
@Slf4j
public class SemaphoreTest {
    // 假设还有两辆车
    private static Semaphore bicycles = new Semaphore(2);

    public static void main(String[] args) {
        Runnable runnable = () -> {
            // 获取当前线程的名称
            String name = Thread.currentThread().getName();
            System.out.println(name + ": 开始上班");
            // 使得抢锁公平
            sleep(50);
            // 尝试获取资源
            boolean has = bicycles.tryAcquire();
            if (has) {
                System.out.println(name + ": 还有车，骑车上班");
                sleep(100);
                System.out.println(name + ": 下班还车");
                // 用完之后释放锁
                bicycles.release();
            } else {
                System.out.println(name + ": 没车了，走路上班吧");
            }
            System.out.println(name + ": 上班时间结束");
        };

        for (int i = 1; i <= 5; i++) {
            System.out.println("------ 星期 " + i + " ------");
            new Thread(runnable, "AAA").start();
            new Thread(runnable, "BBB").start();
            new Thread(runnable, "CCC").start();
            sleep(500);
        }
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
