package com.simple.designpatterns.pattern23.behavioral.strategy;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 策略上下文
 *
 * @author: WuChengXing
 * @create: 2021-07-04 15:42
 **/
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Integer calculation(Integer var1, Integer var2) {
        return strategy.calculation(var1, var2);
    }
}
