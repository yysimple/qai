package com.simple.algorithm.labuladong.chapter01.designmydata.lfu;

import java.util.*;

/**
 * 功能描述: 最近访问频率最低的元素淘汰
 *
 * @author: WuChengXing
 * @create: 2022-01-03 20:01
 **/
public class LFUCache {
    /**
     * 用于存值
     */
    private Map<Integer, Integer> keyToValue;

    /**
     * 用于存键对应的使用频率
     */
    private Map<Integer, Integer> keyToFreq;

    /**
     * 使用频率对应的键值集合
     */
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    /**
     * 最小使用频率
     */
    private Integer minFreq;

    /**
     * 集合的容量
     */
    private Integer cap;

    /**
     * 构造容量为 capacity 的缓存
     *
     * @param capacity
     */
    public LFUCache(int capacity) {
        this.keyToValue = new HashMap<>(capacity);
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    /**
     * 在缓存中查询 key:
     * 1. 判断是否键存在
     * 2. 存在，则增加其使用频率
     * 3. 返回对应的值
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToValue.get(key);
    }

    /**
     * 将 key 和 val 存入缓存:
     * 1. 如果key存在的情况，覆盖值，并增加key的频率
     * 2. 如果key不存在，容量未满，则插入值，更新 fk 的数据
     * 3. 容量满了，先删除指定（符合规则）的 key 然后在插入最新的
     * 4. 最后都需要考虑更新minFreq
     *
     * @param key
     * @param val
     */
    public void put(int key, int val) {
        if (this.cap <= 0) {
            return;
        }

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, val);
            increaseFreq(key);
        }

        // 判断容量是否已满
        if (this.cap <= keyToValue.size()) {
            removeMinFreqKey();
        }

        // 移除之后在进行添加
        keyToValue.put(key, val);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 更新minFreq
        this.minFreq = 1;
    }

    /**
     * 增加使用频率
     *
     * @param key
     */
    private void increaseFreq(int key) {
        // 通过key拿到对应的使用频率
        Integer incrKeyFreq = keyToFreq.get(key);
        // 拿到该freq对应的keys
        LinkedHashSet<Integer> keys = freqToKeys.get(incrKeyFreq);
        // 移除该地方的key
        keys.remove(key);
        // 然后将新key添加在map中
        freqToKeys.putIfAbsent(incrKeyFreq + 1, new LinkedHashSet<>());
        freqToKeys.get(incrKeyFreq + 1).add(key);
        if (keys.isEmpty()) {
            freqToKeys.remove(incrKeyFreq);
            if (this.minFreq.equals(incrKeyFreq)) {
                this.minFreq++;
            }
        }
    }

    /**
     * 移除最少使用的键值对
     */
    private void removeMinFreqKey() {
        // 可能存在的最小值对应的所有的key
        LinkedHashSet<Integer> minKeys = freqToKeys.get(this.minFreq);
        // 拿到迭代器
        Iterator<Integer> iterator = minKeys.iterator();
        Integer deleteKey = iterator.next();
        // 这里淘汰的是最早放入集合中的key
        minKeys.remove(deleteKey);
        if (minKeys.isEmpty()) {
            // 如果集合为空了，就移除该 最小值对应的key集合，这里的最小值不需要去关系，put的时候会去更新
            // 但是，会有个问题，就是minFreq可能在某个时刻不是最新的，如果迭代去跟新，就不符合O(1)了
            freqToKeys.remove(this.minFreq);
        }
        // 然后更新kv表和kf表
        keyToValue.remove(deleteKey);
        keyToFreq.remove(deleteKey);
    }

}
