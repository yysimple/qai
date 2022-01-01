package com.simple.algorithm.labuladong.chapter01.designmydata.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: LRU缓存
 *
 * @author: WuChengXing
 * @create: 2022-01-01 11:12
 **/
public class LRUCache {
    private Map<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int size) {
        cap = size;
        this.map = new HashMap<>(size);
        this.cache = new DoubleList();
    }

    /**
     * 获取一个元素：
     * 1. map中是否存在？不存在返回 -1
     * 2. 将其设置为最近使用
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        // 设置其成为最近是u哦那个
        makeRecently(key);
        // 返回对应值
        return node.value;
    }

    /**
     * 新增加一个元素：
     * 1. 判断key是否存在，存在则删除原先数据，再添加当前数据
     * 2. 不存在，判断是否容量已满，满了选移除首节点
     * 3. 其他都直接添加到尾节点即可
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // 如果key存在
        if (map.containsKey(key)) {
            // 删除原来的key
            deleteKey(key);
            // 添加新的值
            addRecently(key, value);
            return;
        }

        // 如果容量满了,先移除头节点，也即最近最少使用的节点
        if (cap == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    /**
     * 将某个使用的key提到数据尾节点，证明是最近使用的
     *
     * @param key
     */
    private void makeRecently(int key) {
        // 通过key拿到对应的节点
        Node node = map.get(key);
        // 删除对应的节点
        cache.remove(node);
        // 然后再将其添加至队列尾部
        cache.addLast(node);
    }

    /**
     * 添加新元素
     *
     * @param key
     * @param value
     */
    private void addRecently(int key, int value) {
        // 构建新元素
        Node node = new Node(key, value);
        // 将其添加到map种
        map.put(key, node);
        // 将其添加至队列尾部
        cache.addLast(node);
    }

    /**
     * 删除某个key
     *
     * @param key
     */
    private void deleteKey(int key) {
        // 移除map中的记录
        Node remove = map.remove(key);
        // 移除双向列表中的记录
        cache.remove(remove);
    }

    /**
     * 当容器满了，添加的时候，删除最久未使用的元素
     */
    private void removeLeastRecently() {
        // 移除首节点
        Node node = cache.removeFirst();
        // 移除map中的记录
        map.remove(node.key);
    }
}
