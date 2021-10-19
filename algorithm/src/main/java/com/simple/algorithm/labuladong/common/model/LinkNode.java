package com.simple.algorithm.labuladong.common.model;

import lombok.Data;

/**
 * @author WuChengXing
 * @date 2021/10/19
 */
@Data
public class LinkNode<T> {
    public LinkNode<T> next;
    public T val;

    /**
     * 单向链表
     *
     * @param next
     * @param val
     */
    public LinkNode(LinkNode<T> next, T val) {
        this.next = next;
        this.val = val;
    }
}
