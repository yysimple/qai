package com.simple.algorithm.test.demo.link;

import com.simple.algorithm.labuladong.common.model.LinkNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 功能描述: 合并K个升序链表
 *
 * @author: WuChengXing
 * @create: 2022-01-21 14:30
 **/
public class MergeKLists {

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
        LinkNode<Integer> linkNode = mergeKLists(nodes);
        System.out.println(linkNode);
    }

    public LinkNode<Integer> mergeKLists(LinkNode<Integer>[] lists) {
        if (lists.length == 0) {
            return null;
        }
        LinkNode<Integer> vHead = new LinkNode<>(null, -1);
        LinkNode<Integer> p = vHead;
        PriorityQueue<LinkNode<Integer>> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(LinkNode::getVal));
        for (LinkNode<Integer> list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            LinkNode<Integer> poll = pq.poll();
            p.next = poll;
            if (poll.next != null) {
                pq.add(poll.next);
            }
            p = p.next;
        }
        return vHead.next;
    }
}
