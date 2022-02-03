package com.simple.algorithm.newyear.datastruct.linked;

import com.simple.algorithm.newyear.datastruct.init.ListNode;

/**
 * 功能描述: 判断两个链表是否相交
 *
 * @author: WuChengXing
 * @create: 2022-02-03 12:13
 **/
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode p1 = a, p2 = b;
        // 当两个指针对应的节点是指向同一个节点的时候，证明此时是存在相交节点的
        while (p1 != p2) {
            // 如果p1遍历完了，那么就指向另外一个链表
            if (p1 == null) {
                p1 = b;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = a;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
