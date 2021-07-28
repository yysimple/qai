package com.simple.javabase.generic.demo1;

import com.simple.javabase.generic.demo1.impl.BlockOpe;

/**
 * @author WuChengXing
 * @date 2021/7/27
 */
public class GenericTest {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setName("apple");
        apple.setShape("yuan");
        apple.setType("sweet");
        Operation<Apple> operation = new BlockOpe<>();
        Apple processing = operation.Processing(apple);
        System.out.println(processing);
    }
}
