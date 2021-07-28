package com.simple.javabase.generic.demo1.impl;

import com.simple.javabase.generic.demo1.Apple;
import com.simple.javabase.generic.demo1.Fruit;
import com.simple.javabase.generic.demo1.Operation;

/**
 * @author WuChengXing
 * @date 2021/7/27
 */
public class BlockOpe<T extends Fruit> implements Operation<T> {

    @Override
    public <T extends Fruit> T Processing(T fruit) {
        if (fruit instanceof Apple) {
            Apple apple = (Apple) fruit;
            System.out.println("将苹果处理成块状：" + apple.getName() + "block...");
            return (T) apple;
        } else {
            System.out.println("其他水果处理成颗粒：" + fruit.getName());
        }
        return fruit;
    }
}
