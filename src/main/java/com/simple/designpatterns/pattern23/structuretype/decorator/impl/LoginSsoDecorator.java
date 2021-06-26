package com.simple.designpatterns.pattern23.structuretype.decorator.impl;

import com.simple.designpatterns.pattern23.structuretype.decorator.HandlerInterceptor;
import com.simple.designpatterns.pattern23.structuretype.decorator.SsoInterceptorDecorator;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-26 18:05
 **/
@Slf4j
public class LoginSsoDecorator extends SsoInterceptorDecorator {

    private static Map<String, String> authMap = new HashMap<>(2);

    static {
        authMap.put("haha", "query");
        authMap.put("dudu", "query");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public Boolean preHandle(String request, String response, Object handler) {
        Boolean success = super.preHandle(request, response, handler);
        if (!success) {
            return false;
        }
        String userId = request.substring(8);
        String method = authMap.get(userId);
        log.info("单点登录参数：{}， {}", userId, method);
        return "query".equals(method);
    }
}
