package com.simple.javabase.generic.demo1.impl;

import com.simple.javabase.generic.demo1.entity.Apple;
import com.simple.javabase.generic.demo1.entity.Banana;
import com.simple.javabase.generic.demo1.entity.Fruit;
import com.simple.javabase.generic.demo1.FruitDeal;

/**
 * @author WuChengXing
 * @date 2021/7/28
 */
public class DealOpe implements FruitDeal {

    @Override
    public <T extends Fruit> T deal(T fruit) {
        if (fruit instanceof Apple) {
            Apple apple = (Apple) fruit;
            System.out.println("苹果需要清洗：" + apple.getName() + "Wash...");
            return (T) apple;
        } else if (fruit instanceof Banana) {
            Banana banana = (Banana) fruit;
            System.out.println("香蕉需要剥皮：" + banana.getName() + "Peeling...");
            return (T) banana;
        } else {
            System.out.println("其他水果随意：" + fruit.getName());
        }
        return fruit;
    }
}
