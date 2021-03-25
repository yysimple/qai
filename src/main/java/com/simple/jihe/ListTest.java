package com.simple.jihe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-20 09:14
 **/
public class ListTest {
    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        // listTest.testContainsAll();
        listTest.testListObject();
        List<String> linkList = new LinkedList<>();
    }

    public void testContainsAll() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("ab");
        list2.add("ac");
        // 判断是否有交集，并且 list1这个调用方法者 最后会剩下交集
        boolean b = list1.containsAll(list2);
        // true
        System.out.println(b);
        // a
        System.out.println(list1);
    }

    public void testRetainAll() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("ab");
        list2.add("ac");
        // 判断是否有交集，并且 list1这个调用方法者 最后会剩下交集
        boolean b = list1.retainAll(list2);
        // true
        System.out.println(b);
        // a
        System.out.println(list1);
    }

    transient Object[] b;
    private static final Object[] a = {};

    public void testListObject() {
        System.out.println(a == b);
    }

    public ListTest() {
        this.b = a;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
