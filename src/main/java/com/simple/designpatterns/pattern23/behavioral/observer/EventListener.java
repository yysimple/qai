package com.simple.designpatterns.pattern23.behavioral.observer;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 事件监听
 *
 * @author: WuChengXing
 * @create: 2021-07-03 11:47
 **/
public interface EventListener {
    void doEvent(OrderResult orderResult);
}
