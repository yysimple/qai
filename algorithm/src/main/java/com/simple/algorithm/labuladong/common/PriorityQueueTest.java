package com.simple.algorithm.labuladong.common;

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
public class PriorityQueueTest {

    @Test
    public void testPriorityQueue() {
        LinkNode<Integer> l1_2 = new LinkNode<>(null, 3);
        LinkNode<Integer> l1_1 = new LinkNode<>(l1_2, 2);
        LinkNode<Integer> l1_head = new LinkNode<>(l1_1, 2);

        LinkNode<Integer> l2_2 = new LinkNode<>(null, 4);
        LinkNode<Integer> l2_1 = new LinkNode<>(l2_2, 2);
        LinkNode<Integer> l2_head = new LinkNode<>(l2_1, 1);

        List<LinkNode<Integer>> lists = new ArrayList<>();
        lists.add(l1_head);
        lists.add(l2_head);

        PriorityQueue<LinkNode<Integer>> priorityQueue = new PriorityQueue<>(lists.size(), Comparator.comparingInt(a -> a.val));

        // 将 k 个链表的头结点加入最小堆
        for (LinkNode head : lists) {
            if (head != null)
                priorityQueue.add(head);
        }
        System.out.println(priorityQueue.poll());
    }
}
