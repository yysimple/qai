package com.simple.javabase.jihe.list;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author WuChengXing
 * @date 2021/11/18
 */
public class ArrayListTest {

    @Test
    public void normalTest(){
        int old = 10;
        System.out.println(old >> 1);
    }

    @Test
    public void trimToSizeTest() {
        ArrayList al = new ArrayList(10);
        for(int i=0;i<10;i++){
            al.add(i);
        }
        al.add(1);
        al.trimToSize();
        System.out.println("减少数组容量之后: " + al.size());
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

    @Test
    public void addTest(){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        System.out.println(a.size());
    }

}
