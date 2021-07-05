package com.simple.designpatterns.pattern23.behavioral.visitor.impl;

import com.simple.designpatterns.pattern23.behavioral.visitor.DefaultVisitor;
import lombok.extern.slf4j.Slf4j;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 校长类，作为访问者
 *
 * @author: WuChengXing
 * @create: 2021-07-05 23:20
 **/
@Slf4j
public class Principal extends DefaultVisitor {
    @Override
    public void visit(Teacher teacher) {
        log.info(teacher.passingRate());
    }

    @Override
    public void visit(Student student) {
        log.info("排名：{}", student.rank());
    }
}
