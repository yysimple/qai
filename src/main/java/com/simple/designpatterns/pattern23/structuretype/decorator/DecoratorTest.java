package com.simple.designpatterns.pattern23.structuretype.decorator;

import com.simple.designpatterns.pattern23.structuretype.decorator.impl.LoginSsoDecorator;
import com.simple.designpatterns.pattern23.structuretype.decorator.impl.SsoInterceptor;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 装饰器测试类
 *
 * @author: WuChengXing
 * @create: 2021-06-26 17:58
 **/
public class DecoratorTest {
    public static void main(String[] args) {
        LoginSsoDecorator loginSsoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "lsuccesshaha";
        Boolean aBoolean = loginSsoDecorator.preHandle(request, "ssassasa", "a");
        System.out.println("登录：==》"+ (aBoolean ? "成功" : "失败"));
    }
}
