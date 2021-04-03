package com.simple.reflect;

import lombok.Data;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-31 11:12
 **/
@Data
public class Student {
    private int age;
    private String name;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
        System.out.println("My Name is " + name + ",and My age is " + age);
    }

    public Student() {
    }

    public Student(int age) {
        this.age = age;
    }

    private Student(String name) {
        this.name = name;
        System.out.println("My Name is " + name);
    }

    public void noParamVoidPublic(){
        System.out.println("我是无返回,无参数的公共方法");
    }

    private void noParamVoidPrivate(){
        System.out.println("我是无返回,无参数的私有方法");
    }

    public int intVoidPublic(){
        System.out.println("我是有返回,无参数的公共方法");
        return 1;
    }

    public int intVoidPublic(int age){
        System.out.println("我是有返回,有参数的公共方法");
        return 1 + age;
    }

    public static String stringStaticPublic(){
        System.out.println("我是有返回,有参数的公共方法");
        return "static";
    }
}
