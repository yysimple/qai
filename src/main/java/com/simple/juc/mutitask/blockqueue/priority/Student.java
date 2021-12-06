package com.simple.juc.mutitask.blockqueue.priority;

import lombok.Data;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-06 10:01
 **/
@Data
public class Student implements Comparable<Student> {

    private String name;

    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age.compareTo(o.getAge());
    }
}
