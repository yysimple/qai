package com.simple.jvm;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-24 17:29
 **/
public class StringTest {
    public static void main(String[] args) {
        /**
         * 这里的String 只会加载到 rt下面String类，自己定义的不能用到
         */
        String s = "a";
        System.out.println(s);
    }
}
