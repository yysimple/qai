package com.simple.algorithm.labuladong.chapter00.linked;

import com.simple.algorithm.labuladong.common.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * 如果链表中含有环，如何计算这个环的起点？
 *
 * @author WuChengXing
 * @date 2021/10/20
 */
public class DetectCycleLinkNode extends BaseTest {

    @Test
    public void test() {
        LinkNode<Integer> linkNode = NodeInit.initNodeCycle();
        System.out.println(linkNode);
        LinkNode<Integer> node = findNode(linkNode);
        System.out.println(node.val);
    }

    /**
     * 找到循环链表的 环的起点 的位置
     * @param head
     * @return
     */
    public LinkNode<Integer> findNode(LinkNode<Integer> head) {
        if (head == null) {
            return null;
        }
        LinkNode<Integer> fast = head;
        LinkNode<Integer> slow = head;

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
