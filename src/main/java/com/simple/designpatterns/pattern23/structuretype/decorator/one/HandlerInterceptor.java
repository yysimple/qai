package com.simple.designpatterns.pattern23.structuretype.decorator.one;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 拦截器
 *
 * @author: WuChengXing
 * @create: 2021-06-26 17:58
 **/
public interface HandlerInterceptor {

    Boolean preHandle(String request, String response, Object handler);
}
