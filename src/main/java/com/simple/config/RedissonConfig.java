package com.simple.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: redisson的配置
 *
 * @author: WuChengXing
 * @create: 2021-04-16 23:03
 **/
public class RedissonConfig {

    @Bean(destroyMethod = "shutdown")
    RedissonClient redissonClient() throws IOException {
        Config config = new Config();
        config.useSingleServer()
                // 设置nat网络不一致的情况下去ping  redis 设置一分钟一次
                .setPingConnectionInterval(60000)
                .setAddress("redis://192.168.109.135:6379")
                .setPassword("123456");
        return Redisson.create(config);
    }
}
