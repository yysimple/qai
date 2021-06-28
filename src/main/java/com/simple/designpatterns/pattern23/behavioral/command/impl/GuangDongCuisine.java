package com.simple.designpatterns.pattern23.behavioral.command.impl;

import com.simple.designpatterns.pattern23.behavioral.command.ICook;
import com.simple.designpatterns.pattern23.behavioral.command.ICuisine;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-28 22:51
 **/
public class GuangDongCuisine implements ICuisine {

    private ICook cook;

    public GuangDongCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void getCuisine() {
        cook.cooking();
    }
}
