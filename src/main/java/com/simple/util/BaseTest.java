package com.simple.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-27 14:09
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BaseTest {
    @Before
    public void testBefore(){
        log.info("--------------- 测试开始 ---------------");
    }

    @After
    public void testAfter(){
        log.info("--------------- 测试结束 ---------------");
    }
}
