package com.simple.algorithm.labuladong.chapter01.designmydata.lru;

/**
 * 功能描述: 双向链表
 *
 * @author: WuChengXing
 * @create: 2022-01-01 01:35
 **/
public class DoubleList {
    // 头尾虚节点
    private Node head, tail;
    // 链表元素数
    private int size;

    public DoubleList() {
        // 初始化双向链表的数据
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }



}
