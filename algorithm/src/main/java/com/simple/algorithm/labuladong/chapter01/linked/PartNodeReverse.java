package com.simple.algorithm.labuladong.chapter01.linked;

import com.simple.algorithm.labuladong.common.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/25
 */
public class PartNodeReverse {

    @Test
    public void test() {
        System.out.println(LinkNode.printNode(allNodeReverse(NodeInit.initNodeSort(), NodeInit.initNodeSort().next.next)));
    }

    /**
     * 使用遍历的方式遍历整个链表
     *
     * @param a
     */
    public LinkNode<Integer> allNodeReverse(LinkNode<Integer> a, LinkNode<Integer> b) {
        LinkNode<Integer> curr = a, nxt = a, pre = null;
        while (!curr.val.equals(b.val)) {
            nxt = curr.next;
            // 交换位置，反转指针
            curr.next = pre;
            // 更新指针位置
            pre = curr;
            curr = nxt;
        }
        return pre;
    }
}
