package com.simple.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-25 13:28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;

    private Integer age;

    private static Student student = new Student();

    public static Student getInstance(String name, Integer age) {
        if (student == null) {
            synchronized (Student.class) {
                if (student == null) {
                    student = new Student(name, age);
                }
            }
        }
        return student;
    }

}
