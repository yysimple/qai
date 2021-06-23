package com.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/23 15:46
 */
@SpringBootApplication
@MapperScan(basePackages = "com.simple.page")
public class PageTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(PageTestApplication.class, args);
    }
}
