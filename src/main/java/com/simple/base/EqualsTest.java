package com.simple.base;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: equals的对比
 *
 * @author: WuChengXing
 * @create: 2021-03-24 14:04
 **/
public class EqualsTest {
    public static void main(String[] args) {
        /**
         * 这里只重写了名字，所以只会跟着名字进行对比
         */
        Student student1 = new Student("wcx", 17);
        Student student2 = new Student("wcx", 18);
        System.out.println(student1.equals(student2));
    }
}
