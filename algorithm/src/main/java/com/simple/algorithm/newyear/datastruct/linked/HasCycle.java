package com.simple.algorithm.newyear.datastruct.linked;

import com.simple.algorithm.newyear.datastruct.init.ListNode;

/**
 * 功能描述: 判断是否有环
 *
 * @author: WuChengXing
 * @create: 2022-02-01 23:07
 **/
public class HasCycle {

    /**
     * 判断链表是否有环，也是使用快慢指针的方式，如果有环最后快慢就会交叉
     *
     * @param node
     * @return
     */
    public boolean hasCycle(ListNode node) {
        ListNode fastNode = node;
        ListNode slowNode = node;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
