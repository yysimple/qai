package com.simple.javabase.generic.demo1.impl;

import com.simple.javabase.generic.demo1.entity.Apple;
import com.simple.javabase.generic.demo1.entity.Banana;
import com.simple.javabase.generic.demo1.entity.Fruit;
import com.simple.javabase.generic.demo1.FruitDeal;

/**
 * @author WuChengXing
 * @date 2021/7/28
 * <p>
 * 这里是偷懒了，本来这里可以跟 BlockOpe 一样，写多个处理功能的类（Wash<Fruit>）让每个类独立维护,且易扩展
 * 比如我 wash 操作只能支持吃前带皮一起吃的那类水果，其他不需要清洗，这个可以在加一个类去做前置拦截（但是这样继承链路会很长），
 * 可以擦尝试自己写下
 * 然后这里的处理只使用了泛型方法，其实已经满足功能了；
 */
public class DealOpe implements FruitDeal {

    /**
     * @param fruit
     * @param <T>
     * @return
     * 这里其实还有一种方案也可以使用，利用工厂模式抽出这些东西
     */
    @Override
    public <T extends Fruit> T deal(T fruit) {
        if (fruit instanceof Apple) {
            Apple apple = (Apple) fruit;
            String result = apple.getResult() + "\n already Washing ...";
            apple.setResult(result);
            System.out.println("苹果需要清洗：" + apple.getName() + " Washing...");
            return (T) apple;
        } else if (fruit instanceof Banana) {
            Banana banana = (Banana) fruit;
            String result = banana.getResult() + "\n already Peeling ...";
            banana.setResult(result);
            System.out.println("香蕉需要剥皮：" + banana.getName() + " Peeling...");
            return (T) banana;
        } else {
            System.out.println("其他水果随意：" + fruit.getName());
        }
        return fruit;
    }
}
