package com.simple.designpatterns.pattern23.structuretype.decorator;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 单点登录装饰器
 *
 * @author: WuChengXing
 * @create: 2021-06-26 18:01
 **/
public abstract class SsoInterceptorDecorator implements HandlerInterceptor {

    private HandlerInterceptor handlerInterceptor;

    private SsoInterceptorDecorator() {
    }

    protected SsoInterceptorDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public Boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }
}
