package com.simple.algorithm.newyear.datastruct.linked;

import com.simple.algorithm.newyear.datastruct.init.ListNode;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-31 13:26
 **/
public class JoinTwoLinked {

    /**
     * 合并两个链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode joinLinked(ListNode list1, ListNode list2) {
        ListNode vHead = new ListNode(-1);
        ListNode p1 = list1, p2 = list2, p = vHead;
        // 比较两个链表，当随便一个链表遍历完成后，跳出循环
        while (p1 != null && p2 != null) {
            // 比较两个值的大小，如果p1链表的值大于p2的值，将小的那个，也即p2接在vHead后面
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // 虚拟节点一直往下走
            p = p.next;
        }
        // 如果链表长度不一样然后剩下的那些节点就进行拼接
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return p.next;
    }
}
