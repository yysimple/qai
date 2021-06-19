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

    public String name;

    /*public DoubleCheckSingleton(String name) {
        this.name = name;
    }*/

    private static DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton(String name) {
        this.name = name;
    }

    public static DoubleCheckSingleton getInstance(String name) {
        if (doubleCheckSingleton != null) {
            return doubleCheckSingleton;
        }
        synchronized (DoubleCheckSingleton.class) {
            if (doubleCheckSingleton == null) {
                return new DoubleCheckSingleton(name);
            }
        }
        return doubleCheckSingleton;
    }

}
