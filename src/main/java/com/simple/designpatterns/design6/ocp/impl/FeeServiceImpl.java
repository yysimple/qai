package com.simple.designpatterns.design6.ocp.impl;

import com.simple.designpatterns.design6.ocp.FeeService;

/**
 * @author chengxing.wu
 * @date 2021/6/4 17:03
 */
public class FeeServiceImpl implements FeeService {

    /**
     * 公共费率
     */
    public static final Double COMMON_FEE = 0.01D;

    @Override
    public Double getFinancialFee(String level) {
        if ("1".equals(level)) {
            return COMMON_FEE * 0.1;
        } else if ("2".equals(level)) {
            return COMMON_FEE * 0.2;
        } else {
            return COMMON_FEE;
        }
    }

    @Override
    public Double getRestaurantFee(Double fee) {
        return fee;
    }

    @Override
    public Double getSupermarketFee(Double fee) {
        return fee;
    }
}
