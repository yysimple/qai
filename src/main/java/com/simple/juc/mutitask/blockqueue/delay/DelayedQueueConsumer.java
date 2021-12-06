package com.simple.juc.mutitask.blockqueue.delay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-06 11:03
 **/
@Slf4j
@Data
@AllArgsConstructor
public class DelayedQueueConsumer implements Runnable{

    private DelayQueue<DelayedImpl> delayQueue;

    private int messageCount;

    @Override
    public void run() {
        for (int i = 0; i < messageCount; i++) {
            try {
                // 这里来消费会先阻塞一下
                DelayedImpl element = delayQueue.take();
                log.info("开始消费，消费的数据是：===> {}", element);
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }
        }
    }
}
