package com.simple.spring;

import com.simple.spring.config.SpringScanBean;
import com.simple.spring.service.MyBeanFactoryPostProcessorTest;
import com.simple.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: spring源码阅读
 *
 * @author: WuChengXing
 * @create: 2021-03-28 19:39
 **/
public class SpringSourceCodeTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringScanBean.class);
        applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessorTest());
        UserService userService = applicationContext.getBean(UserService.class);
        SynchronousQueue<String> strings = new SynchronousQueue<>();
        userService.sayHello();
    }
}
