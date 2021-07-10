package com.simple.designpatterns.pattern23.behavioral.interpreter;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: sql解释器
 *
 * @author: WuChengXing
 * @create: 2021-07-10 23:52
 **/
public class SQLInterpreter implements SQLExpression {
    private String sqlExpr;

    public SQLInterpreter(String sqlExpr) {
        this.sqlExpr = sqlExpr;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(sqlExpr)) {
            return true;
        }
        return false;
    }
}
