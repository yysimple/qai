package com.simple.designpatterns.pattern23.behavioral.observer.impl;

import com.simple.designpatterns.pattern23.behavioral.observer.EventListener;
import com.simple.designpatterns.pattern23.behavioral.observer.OrderResultBo;
import lombok.extern.slf4j.Slf4j;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: mq
 *
 * @author: WuChengXing
 * @create: 2021-07-03 11:49
 **/
@Slf4j
public class MQEventListener implements EventListener {

    @Override
    public void doEvent(OrderResultBo orderResultBo) {
        log.info("MQ通知 ===>: 尊敬的{}号用户，下单成功！您的订单编号为：{}", orderResultBo.getUserId(), orderResultBo.getOrderId());
    }
}
