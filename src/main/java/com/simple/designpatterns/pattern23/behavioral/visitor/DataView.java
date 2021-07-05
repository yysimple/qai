package com.simple.designpatterns.pattern23.behavioral.visitor;

import com.simple.designpatterns.pattern23.behavioral.visitor.impl.Student;
import com.simple.designpatterns.pattern23.behavioral.visitor.impl.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-07-05 23:31
 **/
public class DataView {
    List<User> users = new ArrayList<>();

    public DataView() {
        users.add(new Student("zyy", "重点班", "1-1"));
        users.add(new Student("wcx", "重点班", "1-2"));
        users.add(new Teacher("wcx001", "重点班", "1-1"));
        users.add(new Teacher("wcx002", "重点班", "1-2"));
    }

    public void show(Visitor visitor) {
        for (User user : users) {
            user.accept(visitor);
        }
    }
}
