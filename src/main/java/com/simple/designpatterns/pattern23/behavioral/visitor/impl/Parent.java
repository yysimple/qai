package com.simple.designpatterns.pattern23.behavioral.visitor.impl;

import com.simple.designpatterns.pattern23.behavioral.visitor.DefaultVisitor;
import lombok.extern.slf4j.Slf4j;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 家长类，只关心学生成绩
 *
 * @author: WuChengXing
 * @create: 2021-07-05 23:29
 **/
@Slf4j
public class Parent extends DefaultVisitor {
    @Override
    public void visit(Student student) {
        log.info("排名：{}, name: {}", student.rank(), student.name);
    }
}
