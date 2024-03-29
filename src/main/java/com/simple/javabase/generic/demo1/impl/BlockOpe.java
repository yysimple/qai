package com.simple.javabase.generic.demo1.impl;

import com.simple.javabase.generic.demo1.FruitDeal;
import com.simple.javabase.generic.demo1.entity.Fruit;
import com.simple.javabase.generic.demo1.Operation;
import com.simple.javabase.generic.demo1.entity.TypeBlock;

/**
 * @author WuChengXing
 * @date 2021/7/27
 * <T extends TypeBlock>：该类只能支持 TypeBlock 和 其子类的类类型传入，可以理解泛型限定了引入
 */
public class BlockOpe<T extends TypeBlock> implements Operation<T> {

    private final FruitDeal fruitDeal;

    public BlockOpe(FruitDeal fruitDeal) {
        this.fruitDeal = fruitDeal;
    }

    @Override
    public T Processing(T fruit) {
        T deal = fruitDeal.deal(fruit);
        String result = deal.getResult() + "\n already deal - 切成块状";
        deal.setResult(result);
        System.out.println("切成块状..." + deal.getName());
        return deal;
    }
}
