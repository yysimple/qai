package com.simple.algorithm.labuladong.chapter01.designmydata.lfu;

import org.junit.jupiter.api.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-04 17:54
 **/
public class LFUTest {

    @Test
    public void test() {
        // 构造一个容量为 2 的 LFU 缓存
        LFUCache cache = new LFUCache(2);

        // 插入两对 (key, val)，对应的 freq 为 1
        cache.put(1, 10);
        cache.put(2, 20);

        // 查询 key 为 1 对应的 val
        // 返回 10，同时键 1 对应的 freq 变为 2
        System.out.println(cache.get(1));

        // 容量已满，淘汰 freq 最小的键 2
        // 插入键值对 (3, 30)，对应的 freq 为 1
        cache.put(3, 30);

        // 键 2 已经被淘汰删除，返回 -1
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
