package com.simple.algorithm.newyear.datastruct.linked;

import com.simple.algorithm.newyear.datastruct.init.ListNode;

/**
 * 功能描述: 倒数第N个
 *
 * @author: WuChengXing
 * @create: 2022-02-01 20:51
 **/
public class FindFromEnd {

    /**
     * 找到倒数第N个节点
     *
     * @param root
     * @param n
     * @return
     */
    public ListNode findFromEnd(ListNode root, int n) {
        ListNode node = root;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        while (node != null) {
            root = root.next;
            node = node.next;
        }
        return root;
    }
}
