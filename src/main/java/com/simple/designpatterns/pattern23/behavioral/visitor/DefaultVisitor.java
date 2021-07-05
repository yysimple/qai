package com.simple.designpatterns.pattern23.behavioral.visitor;

import com.simple.designpatterns.pattern23.behavioral.visitor.impl.Student;
import com.simple.designpatterns.pattern23.behavioral.visitor.impl.Teacher;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-07-05 23:25
 **/
public class DefaultVisitor implements Visitor{
    @Override
    public void visit(Teacher teacher) {

    }

    @Override
    public void visit(Student student) {

    }
}
