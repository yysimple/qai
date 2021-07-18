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

    /**
     * 这里可以理解为，通过固定的sqlExpr，可以判断 传进来的sql是查询语句还是更新语句
     * @param context
     * @return
     */
    @Override
    public boolean interpret(String context) {
        if (context.contains(sqlExpr)) {
            return true;
        }
        return false;
    }
}
