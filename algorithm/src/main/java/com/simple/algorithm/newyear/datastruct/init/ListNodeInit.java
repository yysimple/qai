package com.simple.algorithm.newyear.datastruct.init;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-02-01 21:01
 **/
public class ListNodeInit {

    /**
     * 初始化一个单向链表
     *
     * @return
     */
    public static ListNode init01() {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        return l1;
    }
}
