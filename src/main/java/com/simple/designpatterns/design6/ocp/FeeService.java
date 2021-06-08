package com.simple.designpatterns.design6.ocp;

/**
 * @author chengxing.wu
 * @date 2021/6/4 13:34
 */
public interface FeeService {

    /**
     * 金融费率
     *
     * @param level
     * @return
     */
    Double getFinancialFee(String level);

    /**
     * 餐饮店的费率
     *
     * @param fee
     * @return
     */
    Double getRestaurantFee(Double fee);

    /**
     * 超市的费率
     *
     * @param fee
     * @return
     */
    Double getSupermarketFee(Double fee);
}

