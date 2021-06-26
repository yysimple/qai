package com.simple.designpatterns.pattern23.structuretype.decorator.impl;

import com.simple.designpatterns.pattern23.structuretype.decorator.HandlerInterceptor;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-26 18:19
 **/
public class SsoInterceptor implements HandlerInterceptor {
    @Override
    public Boolean preHandle(String request, String response, Object handler) {
        String substring = request.substring(1, 8);

        return substring.equals("success");
    }
}
