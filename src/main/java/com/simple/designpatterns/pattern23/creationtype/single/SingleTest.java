package com.simple.designpatterns.pattern23.creationtype.single;

import com.simple.designpatterns.pattern23.creationtype.single.util.ObjectAddressUtil;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-19 12:11
 **/
public class SingleTest {
    public static void main(String[] args) {

        DoubleCheckSingleton t1 = DoubleCheckSingleton.getInstance();
        System.out.println("t1对象 ==> " + t1 + ", 内存地址： ==> " + ObjectAddressUtil.getAddresses(t1));
        DoubleCheckSingleton t2 = DoubleCheckSingleton.getInstance();
        System.out.println("t2对象 ==> " + t2 + ", 内存地址： ==> " + ObjectAddressUtil.getAddresses(t2));
    }
}
