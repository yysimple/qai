package com.simple.algorithm.test.demo.link;

import com.simple.algorithm.labuladong.common.model.LinkNode;
import org.junit.Test;

/**
 * 功能描述: 合并两个有序链表
 *
 * @author: WuChengXing
 * @create: 2022-01-21 13:43
 **/
public class MergeTwoLists {

    @Test
    public void test() {
        LinkNode<Integer> l1_2 = new LinkNode<>(null, 6);
        LinkNode<Integer> l1_1 = new LinkNode<>(l1_2, 4);
        LinkNode<Integer> l1_head = new LinkNode<>(l1_1, 1);

        LinkNode<Integer> l2_2 = new LinkNode<>(null, 5);
        LinkNode<Integer> l2_1 = new LinkNode<>(l2_2, 4);
        LinkNode<Integer> l2_head = new LinkNode<>(l2_1, 3);
        LinkNode<Integer> linkNode = mergeTwoLists(l1_head, l2_head);
        System.out.println(linkNode);
    }

    public LinkNode<Integer> mergeTwoLists(LinkNode<Integer> l1, LinkNode<Integer> l2) {
        LinkNode<Integer> vHead = new LinkNode<>(null, -1);
        LinkNode<Integer> one = l1, two = l2, p = vHead;
        while (one != null && two != null) {
            if (one.getVal() > two.getVal()) {
                p.next = two;
                two = two.next;
            } else {
                p.next = one;
                one = one.next;
            }
            p = p.next;
        }
        if (one == null) {
            p.next = two;
        }
        if (two == null) {
            p.next = one;
        }
        return vHead.next;
    }
}
