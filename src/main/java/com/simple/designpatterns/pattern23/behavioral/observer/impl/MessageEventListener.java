package com.simple.designpatterns.pattern23.behavioral.observer.impl;

import com.simple.designpatterns.pattern23.behavioral.observer.EventListener;
import com.simple.designpatterns.pattern23.behavioral.observer.OrderResult;
import lombok.extern.slf4j.Slf4j;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 发送消息
 *
 * @author: WuChengXing
 * @create: 2021-07-03 11:56
 **/
@Slf4j
public class MessageEventListener implements EventListener {
    @Override
    public void doEvent(OrderResult orderResult) {
        log.info("消息通知 ===>: 尊敬的{}号用户，下单成功！您的订单编号为：{}", orderResult.getUserId(), orderResult.getOrderId());
    }
}