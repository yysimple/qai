package com.simple.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-06 12:49
 **/
@Slf4j
public class CalTest {

    @Test
    public void test(){
        BigDecimal standardFee = new BigDecimal("0.39");
        BigDecimal multiDbFree = new BigDecimal("0.38");
        BigDecimal subtract = standardFee.subtract(multiDbFree);
        if (subtract.compareTo(BigDecimal.ZERO) < 0) {
            log.info("数据库里的费率小于标准费率，需要补贴的费率={}", multiDbFree);
        } else {
            log.info("数据库里的费率大于等于标准费率，需要补贴的费率={}", multiDbFree);
        }
    }
}
