package com.simple.algorithm.labuladong.common.init;

import com.simple.algorithm.labuladong.common.model.LinkNode;

/**
 * @author WuChengXing
 * @date 2021/10/20
 */
public class NodeInit {

    public static LinkNode<Integer> initNode() {
        LinkNode<Integer> l4 = new LinkNode<>(null, 9);
        LinkNode<Integer> l3 = new LinkNode<>(l4, 5);
        LinkNode<Integer> l2 = new LinkNode<>(l3, 4);
        LinkNode<Integer> l1 = new LinkNode<>(l2, 3);
        LinkNode<Integer> head = new LinkNode<>(l1, 1);
        return head;
    }

    public static LinkNode<Integer> initNode2() {
        LinkNode<Integer> l5 = new LinkNode<>(null, 12);
        LinkNode<Integer> l4 = new LinkNode<>(l5, 7);
        LinkNode<Integer> l3 = new LinkNode<>(l4, 6);
        LinkNode<Integer> l2 = new LinkNode<>(l3, 5);
        LinkNode<Integer> l1 = new LinkNode<>(l2, 3);
        LinkNode<Integer> head = new LinkNode<>(l1, 1);
        return head;
    }

    public static LinkNode<Integer> initNodeCycle() {
        LinkNode<Integer> l5 = new LinkNode<>(null, 11);
        LinkNode<Integer> l4 = new LinkNode<>(l5, 7);
        LinkNode<Integer> l3 = new LinkNode<>(l4, 6);
        LinkNode<Integer> l2 = new LinkNode<>(l3, 5);
        LinkNode<Integer> l1 = new LinkNode<>(l2, 1);
        l5.next = l2;
        return l1;
    }
}
