package com.simple.algorithm.labuladong.chapter01.linked;

import com.simple.algorithm.labuladong.common.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/25
 */
public class KGroupReverseLinked extends BaseTest {
    @Test
    public void test() {
        System.out.println(LinkNode.printNode(testKGroupReverseLinked(NodeInit.initNodeSort(), 2)));
    }

    public LinkNode<Integer> testKGroupReverseLinked(LinkNode<Integer> head, int k) {
        LinkNode<Integer> a = head, b = head;
        if (head == null) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            // 后面如果不足K个节点，就直接返回原链表
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        LinkNode<Integer> newNode = PartNodeReverse.partNodeReverse(a, b);
        a.next = testKGroupReverseLinked(b, k);
        return newNode;
    }
}
