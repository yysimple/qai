package com.simple.algorithm.labuladong.chapter01.designmydata.lru;

import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-01 11:36
 **/
public class LruTest {

    @Test
    public void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache);
    }
}
