package com.simple.designpatterns.pattern23.creationtype.single;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 懒汉式，线程不安全
 *
 * @author: WuChengXing
 * @create: 2021-07-13 00:26
 **/
public class LazyUnSafe {
    private static LazyUnSafe lazyUnSafe;

    private LazyUnSafe() {
    }

    public static LazyUnSafe getInstance() {
        if (lazyUnSafe != null) {
            return lazyUnSafe;
        }
        lazyUnSafe = new LazyUnSafe();
        return lazyUnSafe;
    }
}
