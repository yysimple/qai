package com.simple.algorithm.newyear.datastruct.linked;

import com.simple.algorithm.newyear.datastruct.init.ListNode;

/**
 * 功能描述: 找到环节点的环起始点
 *
 * @author: WuChengXing
 * @create: 2022-02-03 12:03
 **/
public class FindCycleNode {

    /**
     * 找到对应的环节点，思路也是使用快慢指针的方式
     *
     * @param root
     * @return
     */
    public ListNode findCycleNode(ListNode root) {
        ListNode fast = root;
        ListNode slow = root;
        // 这里是找到两者相交的节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // 这里是置为root，然后跟块指针一直往后走，就能找到对应的环起点
        slow = root;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
