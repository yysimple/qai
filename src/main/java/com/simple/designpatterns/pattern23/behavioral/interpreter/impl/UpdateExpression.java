package com.simple.designpatterns.pattern23.behavioral.interpreter.impl;

import com.simple.designpatterns.pattern23.behavioral.interpreter.SQLExpression;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 更新解释器
 *
 * @author: WuChengXing
 * @create: 2021-07-10 23:57
 **/
public class UpdateExpression implements SQLExpression {

    private SQLExpression sqlExpression;

    public UpdateExpression(SQLExpression sqlExpression) {
        this.sqlExpression = sqlExpression;
    }

    @Override
    public boolean interpret(String context) {
        return sqlExpression.interpret(context);
    }
}
