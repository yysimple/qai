package com.simple.algorithm.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 功能描述: 基础测试类
 *
 * @author: WuChengXing
 * @create: 2021-10-07 17:14
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class AlgorithmBaseTest {

    Long start;
    Long end;
    Long nanoStart;
    Long nanoEnd;

    @Before
    public void before() {
        start = System.currentTimeMillis();
        nanoStart = System.nanoTime();
        System.out.println("===== test start ========");
    }

    @After
    public void after() {
        end = System.currentTimeMillis();
        nanoEnd = System.nanoTime();
        System.out.println("===== test end ========");
        System.out.println("test millis time: ==> " + (end - start));
        System.out.println("test nano time: ==> " + (nanoEnd - nanoStart));
    }
}
