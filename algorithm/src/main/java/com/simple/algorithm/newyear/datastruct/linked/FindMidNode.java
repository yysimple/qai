package com.simple.algorithm.newyear.datastruct.linked;

import com.simple.algorithm.newyear.datastruct.init.ListNode;
import com.simple.algorithm.newyear.datastruct.init.ListNodeInit;
import org.junit.jupiter.api.Test;

/**
 * 功能描述: 查询中间节点
 *
 * @author: WuChengXing
 * @create: 2022-02-01 22:31
 **/
public class FindMidNode {

    @Test
    public void test() {
        System.out.println(findMidNode(ListNodeInit.init01()));
    }

    /**
     * 找到链表的中间节点
     *
     * @param node
     * @return
     */
    public ListNode findMidNode(ListNode node) {
        ListNode tmp1 = node;
        ListNode tmp2 = node;
        while (tmp2 != null && tmp2.next != null) {
            tmp1 = tmp1.next;
            tmp2 = tmp2.next.next;
        }
        return tmp1;
    }
}
