package com.simple.algorithm.newyear.datastruct.linked;

import com.simple.algorithm.newyear.datastruct.init.ListNode;

/**
 * 功能描述: 翻转链表
 *
 * @author: WuChengXing
 * @create: 2022-02-06 15:22
 **/
public class ReverseListNode {

    /**
     * 通过遍历的方式反转链表
     *
     * @param root
     * @return
     */
    public ListNode reverseAllNode(ListNode root) {
        // 这里定义三个几点，用于后续的指针移动
        ListNode curr = root, next = root, pre = null;
        while (curr != null) {
            // next现在对应的是头部节点
            next = curr.next;
            // 这里curr下一个节点为上一个节点，这样理解就是前后节点进行了交换
            curr.next = pre;
            // 然后交换当前节点，往后推进
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 以递归的形式完成链表的反转
     *
     * @param root
     * @return
     */
    public ListNode reverseNodeDG(ListNode root) {
        if (root == null) {
            return null;
        }
        if (root.next == null) {
            return root;
        }
        ListNode last = reverseAllNode(root.next);
        // 也是进行13交换，然就将头节点的下一个节点置空
        root.next.next = root;
        root.next = null;
        return last;
    }

    /**
     * 递归的方式反转第N个节点
     */
    ListNode pre = null;

    public ListNode reverseNDG(ListNode root, int n) {
        if (n == 1) {
            pre = root.next;
            return root;
        }
        ListNode last = reverseNDG(root.next, n - 1);
        root.next.next = root;
        root.next = pre;
        return last;
    }

    public ListNode reversePartNNode(ListNode root, int n, int m) {
        if (m == 1) {
            return reverseNDG(root, n);
        }
        // 这里就相当于一直让m趋近于1，一直减
        root.next = reversePartNNode(root.next, n - 1, m - 1);
        return root;
    }

}
