package com.simple.redis;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: redis原子性操作
 *
 * @author: WuChengXing
 * @create: 2021-04-07 17:47
 **/
public class RedisTest {

    @Test
    public void redisLockTest() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.opsForValue().set("aaa", 5);
        new Thread(() -> {
            Integer a1 = (Integer) redisTemplate.opsForValue().get("aaa");
            a1--;
            System.out.println(Thread.currentThread().getName() + ": " + a1);
            redisTemplate.opsForValue().set("aaa", a1);
        }, "A").start();

        new Thread(() -> {
            Integer a2 = (Integer) redisTemplate.opsForValue().get("aaa");
            a2--;
            System.out.println(Thread.currentThread().getName() + ": " + a2);
            redisTemplate.opsForValue().set("aaa", a2);
        }, "B").start();
    }
}
