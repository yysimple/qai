package com.simple.designpatterns.pattern23.behavioral.visitor;

import com.simple.designpatterns.pattern23.behavioral.visitor.impl.Student;
import com.simple.designpatterns.pattern23.behavioral.visitor.impl.Teacher;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 访问者身份的父接口
 *
 * @author: WuChengXing
 * @create: 2021-07-05 23:06
 **/
public interface Visitor {
    /**
     * 获取老师相关的信息
     * @param teacher
     */
    void visit(Teacher teacher);

    /**
     * 获取学生相关信息
     * @param student
     */
    void visit(Student student);
}
