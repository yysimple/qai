package com.simple.designpatterns.pattern23.behavioral.interpreter;

import com.simple.designpatterns.pattern23.behavioral.interpreter.impl.SelectExpression;
import com.simple.designpatterns.pattern23.behavioral.interpreter.impl.UpdateExpression;

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
        SelectExpression select = getSelect();
        UpdateExpression update = getUpdate();
        System.out.println("select * from student? this is a select sql? ==> " + select.interpret("select"));
        System.out.println("update student set name = 'zyy' where id = 1? this is a update sql? ==> " + update.interpret("update"));
    }

    public static SelectExpression getSelect() {
        // 设置解释器模板
        SQLInterpreter select = new SQLInterpreter("select");
        return new SelectExpression(select);
    }

    public static UpdateExpression getUpdate() {
        // 设置解释器模板
        SQLInterpreter update = new SQLInterpreter("update");
        return new UpdateExpression(update);
    }
}
