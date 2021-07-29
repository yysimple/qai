package com.simple.javabase.reflect.reflect01;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-31 11:01
 **/
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String str = "abc";
        Class<? extends String> aClass = str.getClass();
        System.out.println(aClass);

        System.out.println("===================");

        String stringStr = "java.lang.String";
        Class<?> clz = Class.forName(stringStr);
        System.out.println(clz.getName());

    }
}
