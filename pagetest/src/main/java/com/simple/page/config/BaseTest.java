package com.simple.page.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author WuChengXing
 * @date 2021/9/7
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BaseTest {
    @Before
    public void testBefore() {
        log.info("--------------- 测试开始 ---------------");
    }

    @After
    public void testAfter() {
        log.info("--------------- 测试结束 ---------------");
    }
}
