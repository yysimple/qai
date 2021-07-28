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
        String result = deal.getResult() + "\n already deal - 榨汁";
        deal.setResult(result);
        System.out.println("榨汁..." + deal.getName());
        return deal;
    }
}
