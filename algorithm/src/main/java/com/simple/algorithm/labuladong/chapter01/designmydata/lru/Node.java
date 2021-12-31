package com.simple.algorithm.labuladong.chapter01.designmydata.lru;

/**
 * 功能描述: 节点
 *
 * @author: WuChengXing
 * @create: 2022-01-01 01:09
 **/
public class Node {
    public int key, value;
    public Node prev;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
