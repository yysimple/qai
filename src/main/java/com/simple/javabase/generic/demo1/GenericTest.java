package com.simple.javabase.generic.demo1;

import com.simple.javabase.generic.demo1.entity.Apple;
import com.simple.javabase.generic.demo1.impl.BlockOpe;
import com.simple.javabase.generic.demo1.impl.DealOpe;

/**
 * @author WuChengXing
 * @date 2021/7/27
 */
public class GenericTest {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setName("apple");
        apple.setShape("yuan");
        apple.setSize("big");
        apple.setResult("======== deal fruit ========");
        FruitDeal deal = new DealOpe();
        Operation<Apple> operation = new BlockOpe<>(deal);
        Apple a = operation.Processing(apple);
        System.out.println("最终获取到的结果：==>\n" + a.getResult());
        // Apple processing = operation.Processing(apple);
        // System.out.println(processing);
    }
}
