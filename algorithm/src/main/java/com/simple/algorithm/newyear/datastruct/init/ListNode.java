package com.simple.algorithm.newyear.datastruct.init;

import com.simple.algorithm.labuladong.common.model.LinkNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述: 基础数据类型
 *
 * @author: WuChengXing
 * @create: 2022-01-31 13:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static String printNode(ListNode node) {
        if (node == null) {
            return "什么玩意？";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(node.val).append("->");
        ListNode detectNode = findNode(node);
        if (detectNode != null) {
            return "环暂时不打印了！！";
        }
        while (node.next != null) {
            node = node.next;
            sb.append(node.val).append("->");
        }
        sb.append("stop");
        return sb.append("]").toString();
    }

    public static ListNode findNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

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
