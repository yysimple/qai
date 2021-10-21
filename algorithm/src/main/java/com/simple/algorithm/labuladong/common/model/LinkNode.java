package com.simple.algorithm.labuladong.common.model;

import lombok.Data;

/**
 * @author WuChengXing
 * @date 2021/10/19
 */
@Data
public class LinkNode<T> {
    public LinkNode<T> next;
    public T val;

    /**
     * 单向链表
     *
     * @param next
     * @param val
     */
    public LinkNode(LinkNode<T> next, T val) {
        this.next = next;
        this.val = val;
    }

    public static <T> String printNode(LinkNode<T> node) {
        if (node == null) {
            return "什么玩意？";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(node.val).append("->");
        LinkNode<T> detectNode = findNode(node);
        int step = 0;
        if (detectNode != null) {
            while (node.next != null) {
                node = node.next;
                if (node.next == detectNode) {
                    break;
                }
                sb.append(node.val).append("->");
            }
            //return "环暂时不打印了！！";
        }
        while (node.next != null) {
            node = node.next;
            sb.append(node.val).append("->");
        }
        sb.append("stop");
        return sb.append("]").toString();
    }

    public static <T> LinkNode<T> findNode(LinkNode<T> head) {
        if (head == null) {
            return null;
        }
        LinkNode<T> fast = head;
        LinkNode<T> slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
