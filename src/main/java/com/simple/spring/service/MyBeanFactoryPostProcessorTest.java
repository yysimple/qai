package com.simple.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-28 23:02
 **/
@Component
public class MyBeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    @Autowired
    UserService userService;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 在这里执行的时候，该bean还没有被初始化，所以会报空指针异常
        // userService.sayHello();
        System.out.println("我是自定义的beanFactoryPostProcessor ===> 在bean初始化之前执行");
        System.out.println(beanFactory.getBeanDefinition("userService").getBeanClassName());
    }
}
