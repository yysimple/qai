package com.simple.algorithm.labuladong.chapter00.linked;

import com.simple.algorithm.labuladong.chapter00.linked.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/20
 */
public class LinkMidNode extends BaseTest {

    @Test
    public void test() {
        LinkNode<Integer> midNode = getMidNode(NodeInit.initNode());
        System.out.println(midNode.val);
    }

    /**
     * 这里依旧是快慢指针思路
     *
     * @param head
     * @return
     */
    public LinkNode<Integer> getMidNode(LinkNode<Integer> head) {
        if (head == null) {
            return null;
        }
        LinkNode<Integer> fast = head;
        LinkNode<Integer> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

