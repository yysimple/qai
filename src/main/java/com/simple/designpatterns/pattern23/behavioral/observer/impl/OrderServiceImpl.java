package com.simple.designpatterns.pattern23.behavioral.observer.impl;

import com.simple.designpatterns.pattern23.behavioral.observer.OrderResult;
import com.simple.designpatterns.pattern23.behavioral.observer.OrderService;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-07-03 12:49
 **/
public class OrderServiceImpl extends OrderService {
    @Override
    protected OrderResult initOrder(Long userId) {
        if (userId > 1000) {

            return new OrderResult("下单成功", 200, 21211313513L, userId);
        }
        return new OrderResult("下单失败", 100, 0L, userId);
    }
}
