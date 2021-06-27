package com.simple.designpatterns.pattern23.structuretype.proxy;

import com.simple.designpatterns.pattern23.structuretype.proxy.annotation.Select;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-27 13:00
 **/
@Slf4j
@Component
public class MapperInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Select select = method.getAnnotation(Select.class);
        String value = select.value();
        log.info("select.value ==> {}", value);
        String selectValue = value.replace("#{userId}", args[0].toString());
        log.info("selectValue ==> {}", selectValue);
        return args[0] + ", test proxy, take the select in mapper...";
    }
}
