package com.simple.designpatterns.pattern23.behavioral.interpreter;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: sql解释抽象接口
 *
 * @author: WuChengXing
 * @create: 2021-07-10 23:51
 **/
public interface SQLExpression {
    boolean interpret(String context);
}
