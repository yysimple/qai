package com.simple.algorithm.test.demo.link;

import com.simple.algorithm.test.demo.common.ListNode;

/**
 * 功能描述: 反转部分链表
 *
 * @author: WuChengXing
 * @create: 2022-01-21 16:56
 **/
public class ReversePartNode {

    public ListNode reversePart(ListNode node, int m, int n) {
        if (m == 1) {
            return reverseN(node, n);
        }
        node.next = reversePart(node.next, m - 1, n - 1);
        return node;
    }

    ListNode s = null;

    public ListNode reverseN(ListNode node, int n) {
        if (n == 1) {
            s = node.next;
            return node;
        }
        ListNode listNode = reverseN(node.next, n - 1);
        node.next.next = node;
        node.next = s;
        return listNode;
    }
}
