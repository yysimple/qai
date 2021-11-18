package com.simple.javabase.jihe.list;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author WuChengXing
 * @date 2021/11/17
 */
public class ArrayListView {

    int opeNum = 1000 * 10000;

    @Test
    public void testNoArg() {
        long start = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < opeNum; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("无参构造器：" + (end - start));
    }

    @Test
    public void testHasArg() {
        long start = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>(8);
        for (int i = 0; i < opeNum; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("初始化容量构造器：" + (end - start));
    }

    ArrayList<Integer> add = new ArrayList<>();

    @Test
    public void testAddList() {
        add.add(1);
        add.add(2);
        add.add(3);
        long start = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>(add);
        for (int i = 0; i < opeNum; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("添加集合构造器：" + (end - start));
    }
}
