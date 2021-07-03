package com.simple.designpatterns.pattern23.behavioral.observer.impl;

import com.simple.designpatterns.pattern23.behavioral.observer.EventListener;
import com.simple.designpatterns.pattern23.behavioral.observer.OrderResult;
import com.simple.designpatterns.pattern23.behavioral.observer.enums.EventType;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.spi.schema.EnumTypeDeterminer;

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
    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>(16);

    @SafeVarargs
    public ListenerManager(Enum<EventType>... types) {
        for (Enum<EventType> type : types) {
            this.listeners.put(type, new ArrayList<>());
        }
    }

    public void subscribe(Enum<EventType> typeEnum, EventListener eventListener) {
        List<EventListener> eventListeners = listeners.get(typeEnum);
        eventListeners.add(eventListener);
    }

    public void unsubscribe(Enum<EventType> typeEnum, EventListener eventListener) {
        List<EventListener> eventListeners = listeners.get(typeEnum);
        eventListeners.remove(eventListener);
    }

    public void notify(Enum<EventType> typeEnum, OrderResult orderResult) {
        List<EventListener> eventListeners = listeners.get(typeEnum);
        for (EventListener listener : eventListeners) {
            listener.doEvent(orderResult);
        }
    }

}
