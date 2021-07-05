package com.simple.designpatterns.pattern23.behavioral.visitor.impl;

import com.simple.designpatterns.pattern23.behavioral.visitor.User;
import com.simple.designpatterns.pattern23.behavioral.visitor.Visitor;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-07-05 23:10
 **/
public class Teacher extends User {

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    protected void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String passingRate() {
        return "及格率：" + (Math.random() * 100) + "%";
    }
}
