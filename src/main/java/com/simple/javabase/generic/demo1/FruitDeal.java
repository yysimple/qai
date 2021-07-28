package com.simple.javabase.generic.demo1;

import com.simple.javabase.generic.demo1.entity.Fruit;

/**
 * @author WuChengXing
 * @date 2021/7/28
 */
public interface FruitDeal {
    <T extends Fruit> T deal(T fruit);
}
