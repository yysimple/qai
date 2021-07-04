package com.simple.designpatterns.pattern23.behavioral.strategy;

import com.simple.designpatterns.pattern23.behavioral.strategy.impl.AddStrategy;
import com.simple.designpatterns.pattern23.behavioral.strategy.impl.MutilStrategy;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 策略模式
 *
 * @author: WuChengXing
 * @create: 2021-07-04 15:35
 **/
public class StrategyTest {
    public static void main(String[] args) {
        Context add = new Context(new AddStrategy());
        System.out.println("add ==> : " + add.calculation(1, 2));


        Context mutil = new Context(new MutilStrategy());
        System.out.println("mutil ==> : " + mutil.calculation(1, 2));
    }
}
