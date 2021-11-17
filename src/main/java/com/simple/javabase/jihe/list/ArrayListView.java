package com.simple.javabase.jihe.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author WuChengXing
 * @date 2021/11/17
 */
public class ArrayListView {

    @Test
    public void test() {
        /**
         * 无参构造器：this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
         * this.elementData --> transient Object[] elementData;
         * DEFAULTCAPACITY_EMPTY_ELEMENTDATA --> private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
         *
         * 这里可以发现是没有去初始化所谓的 10 的默认容量？然后源码里面没了？
         *
         *
         *
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> initCapacity = new ArrayList<>(10);
        ArrayList<Integer> initCapacity2 = new ArrayList<>(8);
        Set<Integer> set = new HashSet<>(4);
        ArrayList<Integer> initOtherC = new ArrayList<>(set);
    }
}
