package com.simple.designpatterns.pattern23.behavioral.observer;

import com.simple.designpatterns.pattern23.behavioral.observer.enums.EventType;
import com.simple.designpatterns.pattern23.behavioral.observer.impl.ListenerManager;
import com.simple.designpatterns.pattern23.behavioral.observer.impl.MQEventListener;
import com.simple.designpatterns.pattern23.behavioral.observer.impl.MessageEventListener;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-07-03 12:42
 **/
public abstract class OrderService {
    private final ListenerManager listenerManager;

    public OrderService() {
        // 初始化需要通知的事件 MQ/Message
        listenerManager = new ListenerManager(EventType.MQ, EventType.MESSAGE);
        // 订阅
        listenerManager.subscribe(EventType.MQ, new MQEventListener());
        listenerManager.subscribe(EventType.MESSAGE, new MessageEventListener());
    }

    /**
     * 这里发通知，具体逻辑由子类去实现，子类无需关注消息的推送
     * @param userId
     */
    public void createOrder(Long userId) {
        OrderResultBo orderResultBo = initOrder(userId);
        // 通知，这里可以指定通知哪个消息类型
        listenerManager.notify(EventType.MESSAGE, orderResultBo);
        listenerManager.notify(EventType.MQ, orderResultBo);
    }

    protected abstract OrderResultBo initOrder(Long userId);
}
