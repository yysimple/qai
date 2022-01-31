package com.simple.algorithm.newyear.datastruct.linked;

import com.simple.algorithm.newyear.datastruct.init.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 功能描述: 合并N个链表
 *
 * @author: WuChengXing
 * @create: 2022-01-31 23:57
 **/
public class MergeNListNode {

    /**
     * 合并N个链表
     *
     * @param lists
     * @return
     */
    public ListNode mergeNListNode(ListNode[] lists) {
        // 虚拟头节点
        ListNode vHead = new ListNode(-1);
        ListNode p = vHead;
        // 利用优先级队列进行排序
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        // 遍历整个队列，然后将每个节点放入到队列里面
        for (ListNode listNode : lists) {
            if (listNode != null) {
                // 将所有的队列放到优先级队列中，小的会在最前面
                queue.add(listNode);
            }
        }
        // 然后队列不为空的时候，将元素取出
        while (!queue.isEmpty()) {
            // 拿出队列中的元素
            ListNode minNode = queue.poll();
            // 然后给虚拟节点赋值
            p.next = minNode;
            // 这里就是将最小元素取出来之后，然后又放到队列里面去进行排序
            if (minNode.next != null) {
                queue.add(minNode.next);
            }
            // 然后继续往下走
            p = p.next;
        }
        return vHead.next;
    }
}
