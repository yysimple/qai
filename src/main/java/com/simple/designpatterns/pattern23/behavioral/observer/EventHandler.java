package com.simple.designpatterns.pattern23.behavioral.observer;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 事件监听持利器
 * 待通知的订阅者实现该接口，即具体实现，比如mq接收到了，就去存入数据库的日志表
 *
 * @author: WuChengXing
 * @create: 2021-07-03 11:47
 **/
public interface EventHandler {
    /**
     * 这个给予子类去实现自己的逻辑，例如发送信息模板，mq消息然后存到数据库里
     * @param orderResultBo
     */
    void doEvent(OrderResultBo orderResultBo);
}
