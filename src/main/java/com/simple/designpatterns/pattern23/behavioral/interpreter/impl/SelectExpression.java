package com.simple.designpatterns.pattern23.behavioral.interpreter.impl;

import com.simple.designpatterns.pattern23.behavioral.interpreter.SQLExpression;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 查询语句
 *
 * @author: WuChengXing
 * @create: 2021-07-10 23:55
 **/
public class SelectExpression implements SQLExpression {

    private SQLExpression sqlExpression;

    public SelectExpression(SQLExpression sqlExpression) {
        this.sqlExpression = sqlExpression;
    }

    @Override
    public boolean interpret(String context) {
        return sqlExpression.interpret(context);
    }
}
