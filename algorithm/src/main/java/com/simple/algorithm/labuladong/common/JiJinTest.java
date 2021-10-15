package com.simple.algorithm.labuladong.common;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author WuChengXing
 * @date 2021/10/15
 */
public class JiJinTest extends BaseTest {

    @Test
    public void calDayEarnings() {
        System.out.println(init());
    }

    BigDecimal init() {
        return JiJinModel.total(
                new JiJinModel("xny", new BigDecimal("5205"), new BigDecimal("2.67")),
                new JiJinModel("bdt1", new BigDecimal("2398"), new BigDecimal("3.40")),
                new JiJinModel("bdt2", new BigDecimal("3290"), new BigDecimal("3.08")),
                new JiJinModel("bj", new BigDecimal("3774"), new BigDecimal("-0.64")),
                new JiJinModel("js", new BigDecimal("1673"), new BigDecimal("-0.85")),
                new JiJinModel("jwhy", new BigDecimal("1504"), new BigDecimal("0.00")),
                new JiJinModel("gyrx", new BigDecimal("1132"), new BigDecimal("0.45")),
                new JiJinModel("gdzz", new BigDecimal("1159"), new BigDecimal("2.03")),
                new JiJinModel("hsxy", new BigDecimal("2309"), new BigDecimal("0.46")),
                new JiJinModel("hbzz", new BigDecimal("1829"), new BigDecimal("-1.43")),
                new JiJinModel("ys", new BigDecimal("852"), new BigDecimal("0.58")),
                new JiJinModel("ys", new BigDecimal("481"), new BigDecimal("0.94"))
        );
    }
}
