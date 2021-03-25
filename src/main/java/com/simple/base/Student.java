package com.simple.base;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: 测试
 *
 * @author: WuChengXing
 * @create: 2021-03-24 14:05
 **/
public class Student {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        //多态的弊端是无法使用子类特有的属性和行为，所以得向下转型//将Object向下转型为Person  && this.age.equals(s1.age)
        Student s1 = (Student) obj;
        return this.name.equals(s1.name) ;
    }
}
