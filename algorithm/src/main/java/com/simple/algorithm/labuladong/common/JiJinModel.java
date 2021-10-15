package com.simple.algorithm.labuladong.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author WuChengXing
 * @date 2021/10/15
 */
@Data
public class JiJinModel {

    private String name;

    private BigDecimal base;

    private BigDecimal earningRate;

    private BigDecimal earningMoney;

    public JiJinModel(String name, BigDecimal base, BigDecimal earningRate) {
        this.name = name;
        this.base = base;
        this.earningRate = earningRate;
        this.earningMoney = base.multiply(earningRate.divide(new BigDecimal("100")));
    }

    public static BigDecimal total(JiJinModel... jiJinModels) {
        BigDecimal resMoney = BigDecimal.ZERO;
        for (JiJinModel jiJinModel : jiJinModels) {
            resMoney = resMoney.add(jiJinModel.getEarningMoney());
        }
        return resMoney;
    }
}
