package com.simple.designpatterns.pattern23.behavioral.command;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 调用者
 *
 * @author: WuChengXing
 * @create: 2021-06-28 22:53
 **/
@Slf4j
public class XiaoEr {
    private List<ICuisine> cuisines = new ArrayList<>();

    public void addCuisine(ICuisine cuisine) {
        cuisines.add(cuisine);
    }

    public synchronized void placeOrder(){
        for (ICuisine cuisine : cuisines) {
            cuisine.getCuisine();
        }
        cuisines.clear();
    }
}
