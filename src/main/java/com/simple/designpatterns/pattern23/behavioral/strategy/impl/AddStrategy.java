package com.simple.designpatterns.pattern23.behavioral.strategy.impl;

import com.simple.designpatterns.pattern23.behavioral.strategy.Strategy;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 加法
 *
 * @author: WuChengXing
 * @create: 2021-07-04 15:40
 **/
public class AddStrategy implements Strategy {

    @Override
    public Integer calculation(Integer var1, Integer var2) {
        return var1 + var2;
    }
}
