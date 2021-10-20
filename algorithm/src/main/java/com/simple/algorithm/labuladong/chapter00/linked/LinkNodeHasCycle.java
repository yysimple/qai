package com.simple.algorithm.labuladong.chapter00.linked;

import com.simple.algorithm.labuladong.chapter00.linked.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/20
 */
public class LinkNodeHasCycle extends BaseTest {

    @Test
    public void test() {
        System.out.println(hasCycle(NodeInit.initNodeCycle()));
    }

    /**
     * 环形链表的思路很简单，就是一个“先跑”，然后另外一个指针再跑，然后他们还能相遇，就是环形了
     *
     * @param head
     * @return
     */
    public boolean hasCycle(LinkNode<Integer> head) {
        if (head == null) {
            return false;
        }
        LinkNode<Integer> fast = head;
        LinkNode<Integer> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
