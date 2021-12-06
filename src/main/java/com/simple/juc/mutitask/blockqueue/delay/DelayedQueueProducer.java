package com.simple.juc.mutitask.blockqueue.delay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.DelayQueue;

/**
 * 功能描述: 生产者
 *
 * @author: WuChengXing
 * @create: 2021-12-06 11:00
 **/
@Slf4j
@Data
@AllArgsConstructor
public class DelayedQueueProducer implements Runnable {
    private DelayQueue<DelayedImpl> delayQueue;

    private Integer messageCount;

    private long delayedTime;

    @Override
    public void run() {
        for (int i = 0; i < messageCount; i++) {
            try {
                // 这里开始生产
                DelayedImpl delayedUser = new DelayedImpl(
                        new Random().nextInt(1000) + "", delayedTime);
                log.info("开始生产数据，生产的数据是：===> {}", delayedUser);
                delayQueue.put(delayedUser);
                Thread.sleep(500);
                log.warn("因为要2s后消费，所以我睡了500ms之后来执行了：===> {}", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
