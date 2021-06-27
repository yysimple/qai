package com.simple.designpatterns.pattern23.structuretype.proxy;

import com.simple.util.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-27 12:52
 **/
@Slf4j
public class ProxyTest extends BaseTest {

    @Test
    public void queryUserInfo() {
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(RegisterFactoryBean.class);
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        String res = userMapper.queryUserInfo("10001");
        log.info("res ===> {}", res);
    }
}
