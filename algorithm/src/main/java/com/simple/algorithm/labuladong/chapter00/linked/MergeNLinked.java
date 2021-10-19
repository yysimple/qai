package com.simple.algorithm.labuladong.chapter00.linked;

import com.simple.algorithm.labuladong.common.model.LinkNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author WuChengXing
 * @date 2021/10/19
 */
public class MergeNLinked {

    @Test
    public void test() {
        LinkNode<Integer> l3_2 = new LinkNode<>(null, 6);
        LinkNode<Integer> l3_1 = new LinkNode<>(l3_2, 4);
        LinkNode<Integer> l3_head = new LinkNode<>(l3_1, 3);

        LinkNode<Integer> l1_2 = new LinkNode<>(null, 9);
        LinkNode<Integer> l1_1 = new LinkNode<>(l1_2, 5);
        LinkNode<Integer> l1_head = new LinkNode<>(l1_1, 2);

        LinkNode<Integer> l2_2 = new LinkNode<>(null, 8);
        LinkNode<Integer> l2_1 = new LinkNode<>(l2_2, 5);
        LinkNode<Integer> l2_head = new LinkNode<>(l2_1, 1);

        List<LinkNode<Integer>> lists = new ArrayList<>();
        lists.add(l1_head);
        lists.add(l2_head);
        lists.add(l3_head);

        LinkNode<Integer>[] nodes = new LinkNode[3];
        nodes[0] = l1_head;
        nodes[1] = l2_head;
        nodes[2] = l3_head;
        LinkNode<Integer> linkNode = testMergeNLinked(nodes);
        System.out.println(linkNode);
    }

    public LinkNode<Integer> testMergeNLinked(LinkNode<Integer>[] nodes) {
        LinkNode<Integer> vHead = new LinkNode<>(null, -1);
        LinkNode<Integer> tmpHead = vHead;
        PriorityQueue<LinkNode<Integer>> queue = new PriorityQueue<>(nodes.length, Comparator.comparingInt(a -> a.val));
        for (LinkNode<Integer> node : nodes) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            LinkNode<Integer> node = queue.poll();
            tmpHead.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            tmpHead = tmpHead.next;
        }
        return vHead.next;
    }
}
