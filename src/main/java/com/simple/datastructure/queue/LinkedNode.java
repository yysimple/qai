package com.simple.datastructure.queue;

import lombok.Data;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: 链表
 *
 * @author: WuChengXing
 * @create: 2021-04-28 20:31
 **/
@Data
public class LinkedNode<T> {
    /**
     * 头节点
     */
    Node<T> head;

    /**
     * 尾结点
     */
    Node<T> rear;

    /**
     * 大小
     */
    int size;

    /**
     * 入队列
     *
     * @param data
     */
    public void push(T data) {
        Node<T> node = new Node<>(data, null);
        if (isEmpty()) {
            rear = head = node;
        } else {
            rear.setNext(node);
            rear = node;
        }
        size++;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        } else {
            T data = head.getData();
            head = head.getNext();
            size--;
            return data;
        }
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == null && head == null && size < 1;
    }

    /**
     * 获取队列长度
     *
     * @return
     */
    public int size() {
        return size;
    }


}
