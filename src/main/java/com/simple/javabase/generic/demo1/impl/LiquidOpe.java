package com.simple.javabase.generic.demo1.impl;

import com.simple.javabase.generic.demo1.FruitDeal;
import com.simple.javabase.generic.demo1.Operation;
import com.simple.javabase.generic.demo1.entity.TypeLiquid;

/**
 * @author WuChengXing
 * @date 2021/7/28
 */
public class LiquidOpe<T extends TypeLiquid> implements Operation<T> {
    private FruitDeal fruitDeal;

    public LiquidOpe(FruitDeal fruitDeal) {
        this.fruitDeal = fruitDeal;
    }

    @Override
    public T Processing(T fruit) {
        T deal = fruitDeal.deal(fruit);
        System.out.println("切成块状..." + deal);
        return deal;
    }
}
