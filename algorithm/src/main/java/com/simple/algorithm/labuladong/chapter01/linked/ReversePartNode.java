package com.simple.algorithm.labuladong.chapter01.linked;

import com.simple.algorithm.labuladong.common.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/22
 */
public class ReversePartNode {

    @Test
    public void test() {
        System.out.println(LinkNode.printNode(reversePartNode(NodeInit.initNode(), 2, 4)));
    }

    public LinkNode<Integer> reversePartNode(LinkNode<Integer> head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        // 这里就是用到了逆推过程，知道 m == 1的情况
        head.next = reversePartNode(head.next, m - 1, n - 1);
        return head;
    }

    LinkNode<Integer> tmpNode = null;

    public LinkNode<Integer> reverseN(LinkNode<Integer> head, int n) {
        if (n == 1) {
            tmpNode = head.next;
            return head;
        }
        LinkNode<Integer> last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = tmpNode;
        return last;
    }
}
