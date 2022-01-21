package com.simple.algorithm.test.demo;

import com.simple.algorithm.labuladong.common.model.LinkNode;
import org.junit.Test;

/**
 * 功能描述: 两个链表是否相交
 *
 * @author: WuChengXing
 * @create: 2022-01-21 15:24
 **/
public class GetIntersectionNode {

    @Test
    public void test() {
        LinkNode<Integer> c2 = new LinkNode<>(null, 11);
        LinkNode<Integer> c1 = new LinkNode<>(c2, 9);
        LinkNode<Integer> a2 = new LinkNode<>(c1, 7);
        LinkNode<Integer> a1 = new LinkNode<>(a2, 1);

        LinkNode<Integer> b3 = new LinkNode<>(c1, 4);
        LinkNode<Integer> b2 = new LinkNode<>(b3, 3);
        LinkNode<Integer> b1 = new LinkNode<>(b2, 2);

        System.out.println(getIntersectionNode(a1, b1));
    }

    public boolean getIntersectionNode(LinkNode<Integer> a, LinkNode<Integer> b) {
        LinkNode<Integer> l1 = a, l2 = b;
        while (l1 != l2) {
            if (l1 != null) {
                l1 = l1.next;
            } else {
                l1 = b;
            }
            if (l2 != null) {
                l2 = l2.next;
            } else {
                l2 = a;
            }
            if (l1 == l2) {
                return true;
            }
        }
        return false;
    }
}
