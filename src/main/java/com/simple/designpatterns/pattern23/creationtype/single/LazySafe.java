package com.simple.designpatterns.pattern23.creationtype.single;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 线程安全
 *
 * @author: WuChengXing
 * @create: 2021-07-13 00:28
 **/
public class LazySafe {
    private static LazySafe lazySafe;

    private LazySafe() {
    }

    public static synchronized LazySafe getInstance() {
        if (lazySafe != null) {
            return lazySafe;
        }
        lazySafe = new LazySafe();
        return lazySafe;
    }
}
