package com.simple.designpatterns.pattern23.creationtype.prototype;

import com.simple.designpatterns.pattern23.creationtype.prototype.bo.OrderStatisticBo;

import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 统计
 *
 * @author: WuChengXing
 * @create: 2021-07-13 22:01
 **/
public interface Statistic {
    /**
     * 订单相关统计
     * @param
     */
    Map<String, OrderStatisticBo> totalOrder();
}
