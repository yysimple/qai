package com.simple.algorithm.test.demo.link;

import com.simple.algorithm.test.demo.common.ListNode;

/**
 * 功能描述: 反转整个链表
 *
 * @author: WuChengXing
 * @create: 2022-01-21 16:02
 **/
public class ReverseAllNode {

    public ListNode reverseAllNode(ListNode node) {
        // 如果是单节点，反转自己
        if (node.next == null) {
            return node;
        }
        // 反转自己，先从第二个节点开始反转，拿到最后的节点
        ListNode lastNode = reverseAllNode(node.next);
        // 反转完成后，第二个节点的下一个节点就是最后一个节点的下一个节点，也即为 null，这个时候需要将其
        // 指向头节点，完成全部分反转
        node.next.next = node;
        // 然后将头节点的下一个节点指向null
        node.next = null;
        // 返回最新的链表
        return lastNode;
    }
}
