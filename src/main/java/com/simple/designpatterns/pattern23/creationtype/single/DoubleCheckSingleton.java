package com.simple.designpatterns.pattern23.creationtype.single;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 双重检查
 *
 * @author: WuChengXing
 * @create: 2021-06-19 12:16
 **/
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (doubleCheckSingleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (doubleCheckSingleton == null) {
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;
    }

}
