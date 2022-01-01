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

    /**
     * 添加元素到最后
     *
     * @param node
     */
    public void addLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    /**
     * 移除第一个元素
     */
    public Node removeFirst() {
        // 如果头节点的下一个就是尾节点了，则返回空
        if (head.next == tail) {
            return null;
        }
        // 头节点的下一个就是数据首节点
        Node first = head.next;
        remove(first);
        return first;

    }

    public int size() {
        return size;
    }
}
