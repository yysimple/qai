package com.simple.designpatterns.pattern23.behavioral.interpreter;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 解释器
 *
 * @author: WuChengXing
 * @create: 2021-07-10 09:43
 **/
public class InterpreterTest {
    public static void main(String[] args) {
        SQLExpression select = getSelect();
        SQLExpression update = getUpdate();
        System.out.println("select * from student? this is a select sql? ==> " + select.interpret("select"));
        System.out.println("update student set name = 'zyy' where id = 1? this is a update sql? ==> " + update.interpret("update"));
    }

    public static SQLExpression getSelect() {
        // 设置解释器模板
        return new SQLInterpreter("select");
    }

    public static SQLExpression getUpdate() {
        // 设置解释器模板
        return new SQLInterpreter("update");
    }
}
