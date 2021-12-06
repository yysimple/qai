package com.simple.juc.mutitask.blockqueue.delay;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-06 10:55
 **/
@Data
@Slf4j
public class DelayedImpl implements Delayed {

    private String name;

    private Long expireTime;

    public DelayedImpl(String name, Long available) {
        this.name = name;
        // 过期时间 = 可用时间 + 当前时间
        this.expireTime = available + System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        // 判断expireTime是否大于当前系统时间，并将结果转换成MILLISECONDS
        long diffTime = expireTime - System.currentTimeMillis();
        // 可用时间
        return unit.convert(diffTime, TimeUnit.MICROSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        //compareTo用在DelayedUser的排序
        return (int)(this.expireTime - ((DelayedImpl) o).getExpireTime());
    }
}
