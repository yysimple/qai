package com.simple.algorithm.labuladong.common.model;

import lombok.Data;

/**
 * @author WuChengXing
 * @date 2021/10/19
 */
@Data
public class TwoLindNode<T> {
    public TwoLindNode<T> pre;
    public TwoLindNode<T> next;
    public T val;

    /**
     * 双向链表
     *
     * @param pre
     * @param next
     * @param val
     */
    public TwoLindNode(TwoLindNode<T> pre, TwoLindNode<T> next, T val) {
        this.pre = pre;
        this.next = next;
        this.val = val;
    }
}
