package com.simple.designpatterns.pattern23.behavioral.observer.impl;

import com.simple.designpatterns.pattern23.behavioral.observer.EventListener;
import com.simple.designpatterns.pattern23.behavioral.observer.OrderResultBo;
import com.simple.designpatterns.pattern23.behavioral.observer.enums.EventType;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 监听事件管理
 *
 * @author: WuChengXing
 * @create: 2021-07-03 11:57
 **/
@Slf4j
public class ListenerManager {
    /**
     * 存放枚举里面的订阅者，以订阅者类型为key
     */
    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>(16);

    @SafeVarargs
    public ListenerManager(Enum<EventType>... types) {
        for (Enum<EventType> type : types) {
            this.listeners.put(type, new ArrayList<>());
        }
    }

    /**
     * 订阅，MQ == new Mqxxx()
     * @param typeEnum
     * @param eventListener
     */
    public void subscribe(Enum<EventType> typeEnum, EventListener eventListener) {
        List<EventListener> eventListeners = listeners.get(typeEnum);
        eventListeners.add(eventListener);
    }

    public void unsubscribe(Enum<EventType> typeEnum, EventListener eventListener) {
        List<EventListener> eventListeners = listeners.get(typeEnum);
        eventListeners.remove(eventListener);
    }

    /**
     * 通知已经订阅的成员
     * @param typeEnum
     * @param orderResultBo
     */
    public void notify(Enum<EventType> typeEnum, OrderResultBo orderResultBo) {
        // 这里可以拿到对应的发送消息的类型
        List<EventListener> eventListeners = listeners.get(typeEnum);
        for (EventListener listener : eventListeners) {
            listener.doEvent(orderResultBo);
        }
    }

}
