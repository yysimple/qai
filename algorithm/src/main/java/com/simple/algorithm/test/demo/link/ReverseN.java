package com.simple.algorithm.test.demo.link;

import com.simple.algorithm.test.demo.common.ListNode;

/**
 * 功能描述: 反转前N个链表
 *
 * @author: WuChengXing
 * @create: 2022-01-21 16:35
 **/
public class ReverseN {

    ListNode s = null;

    public ListNode reverseNNode(ListNode head, int n) {
        if (n == 1) {
            s = head.next;
            return head;
        }
        ListNode lastNode = reverseNNode(head.next, n - 1);
        head.next.next = head;
        // 这里的话就不是为null了，而是将后面不需要转换的节点直接拼上去
        head.next = s;
        return lastNode;
    }
}
