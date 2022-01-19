package com.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.sql.DataSourceDefinition;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-04-07 18:54
 **/
@MapperScan(basePackages = {
        "com.simple.designpatterns.pattern23.structuretype.proxy"
})
@SpringBootApplication
public class MianshiApplication {
    public static void main(String[] args) {
        // 1. 通过SpringApplication直接调用静态run方法；
        // SpringApplication.run(MianshiApplication.class, args);

        // 2. 通过SpringApplicationBuilder构建出SpringApplication启动
        new SpringApplicationBuilder(MianshiApplication.class)
                .listeners(event -> {
                    System.err.println("接收到各种事件：" + event.getClass().getSimpleName());
                })
                .run(args);

        // 3. 通过构造器初始化SpringApplication，然后在调用run方法
        // SpringApplication springApplication = new SpringApplication(MianshiApplication.class);
        // springApplication.run();
    }
}
