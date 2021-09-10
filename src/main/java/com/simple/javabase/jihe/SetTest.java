package com.simple.javabase.jihe;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: set源码阅读
 *
 * @author: WuChengXing
 * @create: 2021-03-24 14:42
 **/
public class SetTest {
    public static void main(String[] args) {
        // private transient HashMap<E,Object> map;
        // 扩容算法 map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));、
        // add方法 return map.put(e, PRESENT)==null;
        Set<String> set1 = new HashSet<>();



        Set<String> set2 = new LinkedHashSet<>();
    }
}
