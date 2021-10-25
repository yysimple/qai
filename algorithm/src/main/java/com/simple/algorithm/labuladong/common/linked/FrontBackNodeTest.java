package com.simple.algorithm.labuladong.common.linked;

import com.simple.algorithm.labuladong.common.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/25
 */
public class FrontBackNodeTest {

    LinkNode<Integer> linkNode = NodeInit.initNodeSort();

    @Test
    public void testFront() {
        frontTest(linkNode);
    }

    public void frontTest(LinkNode<Integer> head) {
        if (head == null) {
            return;
        }
        // 前序遍历
        System.out.println(head.val);
        frontTest(head.next);
        // 后续遍历
        System.out.println(head.val);
    }

}
