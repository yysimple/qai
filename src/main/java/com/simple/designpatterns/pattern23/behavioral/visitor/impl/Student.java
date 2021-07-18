package com.simple.designpatterns.pattern23.behavioral.visitor.impl;

import com.simple.designpatterns.pattern23.behavioral.visitor.User;
import com.simple.designpatterns.pattern23.behavioral.visitor.Visitor;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 学生
 *
 * @author: WuChengXing
 * @create: 2021-07-05 23:11
 **/
public class Student extends User {


    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    /**
     * 接受访问者的访问
     * @param visitor
     */
    @Override
    protected void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * 独特的逻辑，这里可以是数据之类的
     * @return
     */
    public int rank() {
        return (int) (Math.random() * 100);
    }
}
