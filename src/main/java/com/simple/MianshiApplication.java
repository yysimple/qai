package com.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-04-07 18:54
 **/
@SpringBootApplication
@MapperScan(basePackages = {
        "com.simple.designpatterns.pattern23.structuretype.proxy"
})
public class MianshiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MianshiApplication.class, args);
    }
}
