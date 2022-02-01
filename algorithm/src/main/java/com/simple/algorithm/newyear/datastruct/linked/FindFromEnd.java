package com.simple.algorithm.newyear.datastruct.linked;

import com.simple.algorithm.newyear.datastruct.init.ListNode;
import com.simple.algorithm.newyear.datastruct.init.ListNodeInit;
import org.junit.jupiter.api.Test;

/**
 * 功能描述: 倒数第N个
 *
 * @author: WuChengXing
 * @create: 2022-02-01 20:51
 **/
public class FindFromEnd {

    @Test
    public void test() {
        System.out.println(findFromEnd(ListNodeInit.init01(), 2));
    }

    /**
     * 找到倒数第N个节点
     *
     * @param root
     * @param n
     * @return
     */
    public ListNode findFromEnd(ListNode root, int n) {
        ListNode node = root;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        while (node != null) {
            root = root.next;
            node = node.next;
        }
        return root;
    }
}
