package com.simple.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-04-16 23:06
 **/
@RestController
public class RedisController {

    /*@Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/deductStock")
    public String deductStock() {
        String lock = "stock_lock";
        BoundValueOperations<String, String> stringBound = stringRedisTemplate.boundValueOps("stock");
        *//*BoundValueOperations<String, String> stockLock = stringRedisTemplate.boundValueOps(lock);
        // 客户端id（解决因为业务时间过长导致锁失效的问题（大多数是线程之间释放另外线程的锁））
        String clientId = UUID.randomUUID().toString();
        // 获取到一个锁
        Boolean a = stockLock.setIfAbsent(clientId, 10, TimeUnit.SECONDS);
        if (!a) {
            return "error";
        }*//*
        RLock rLock = redissonClient.getLock(lock);
        try {
            rLock.lock();
            int stock = Integer.parseInt(Objects.requireNonNull(stringBound.get()));
            if (stock > 0) {
                int realStock = stock - 1;
                System.out.println("剩余库存：==> " + realStock);
                stringBound.set(String.valueOf(realStock));
            } else {
                System.out.println("库存不足");
            }
        } finally {
           *//* if (clientId.equals(stockLock.get())) {
                stringRedisTemplate.delete(lock);
            }*//*
            rLock.unlock();
        }
        return "ok";
    }*/
}
