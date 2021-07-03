package com.simple.designpatterns.pattern23.behavioral.observer;

import com.simple.designpatterns.pattern23.behavioral.observer.impl.OrderServiceImpl;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 观察者模式
 *
 * @author: WuChengXing
 * @create: 2021-07-03 11:17
 **/
public class ObserverTest {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        orderService.createOrder(15135L);
    }
}
