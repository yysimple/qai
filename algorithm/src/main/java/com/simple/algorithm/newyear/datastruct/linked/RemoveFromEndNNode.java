package com.simple.algorithm.newyear.datastruct.linked;

import com.simple.algorithm.newyear.datastruct.init.ListNode;
import com.simple.algorithm.newyear.datastruct.init.ListNodeInit;
import org.junit.jupiter.api.Test;

/**
 * 功能描述: 删除倒数第N个节点
 *
 * @author: WuChengXing
 * @create: 2022-02-01 21:10
 **/
public class RemoveFromEndNNode {

    @Test
    public void test() {
        System.out.println(removeFromEndNNode(ListNodeInit.init01(), 2));
    }

    /**
     * 删除倒数第N个节点
     *
     * @param node
     * @param n
     * @return
     */
    public ListNode removeFromEndNNode(ListNode node, int n) {
        ListNode vHead = new ListNode(-1);
        vHead.next = node;
        FindFromEnd findFromEnd = new FindFromEnd();
        // 找到上一个节点数据，然后删除下一个节点
        ListNode fromEnd = findFromEnd.findFromEnd(node, n + 1);
        fromEnd.next = fromEnd.next.next;
        return vHead.next;
    }
}
