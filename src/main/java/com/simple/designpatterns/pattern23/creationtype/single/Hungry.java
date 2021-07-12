package com.simple.designpatterns.pattern23.creationtype.single;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 饿汉式
 *
 * @author: WuChengXing
 * @create: 2021-07-13 00:31
 **/
public class Hungry {
    private static Hungry hungry = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return hungry;
    }
}
