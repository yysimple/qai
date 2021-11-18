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

    @Test
    public void testIndexOf() {
        ArrayList<Integer> arrayList = new ArrayList<>(8);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(null);
        arrayList.add(3);
        long start = System.currentTimeMillis();
        int i = arrayList.indexOf(null);
        System.out.println(i);
        long end = System.currentTimeMillis();
        System.out.println("初始化容量构造器：" + (end - start));
    }

    @Test
    public void cloneTest() {
        ArrayList<Integer> arrayList = new ArrayList<>(8);
        arrayList.add(1);
        // [1]
        System.out.println(arrayList);

        Object clone = arrayList.clone();
        arrayList.clear();
        // [1]
        System.out.println(clone);
        // []
        System.out.println(arrayList);
    }

    @Test
    public void toArrayTest() {
        ArrayList<Integer> arrayList = new ArrayList<>(8);
        arrayList.add(1);
        Object[] objects = arrayList.toArray();
        System.out.println(objects.length);
    }

    @Test
    public void toArgArrayTest() {
        ArrayList<String> arrayList = new ArrayList<>(8);
        arrayList.add("1");
        String[] strings = arrayList.toArray(new String[arrayList.size()]);
        System.out.println(strings.length);
    }
}
