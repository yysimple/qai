package com.simple.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-04-08 18:01
 **/
@SpringBootTest
public class RedisTest {

    /*@Autowired
    RedisTemplate redisTemplate;

    @Test
    public void redisLockTest() {
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
    }*/

    @Test
    public void redisPExpireTime() {
        // 1641887099941 - 1641887199941
        System.out.println(System.currentTimeMillis());
    }

}