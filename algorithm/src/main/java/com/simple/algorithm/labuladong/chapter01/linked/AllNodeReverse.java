package com.simple.algorithm.labuladong.chapter01.linked;

import com.simple.algorithm.labuladong.common.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/25
 */
public class AllNodeReverse extends BaseTest {

    @Test
    public void test() {
        System.out.println(LinkNode.printNode(allNodeReverse(NodeInit.initNodeSort())));
    }

    /**
     * 使用遍历的方式遍历整个链表
     *
     * @param head
     */
    public LinkNode<Integer> allNodeReverse(LinkNode<Integer> head) {
        LinkNode<Integer> curr = head, nxt = head, pre = null;
        while (curr != null) {
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
