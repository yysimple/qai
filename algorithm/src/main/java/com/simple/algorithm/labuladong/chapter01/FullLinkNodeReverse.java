package com.simple.algorithm.labuladong.chapter01;

import com.simple.algorithm.labuladong.common.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/21
 */
public class FullLinkNodeReverse extends BaseTest {

    @Test
    public void test() {
        LinkNode<Integer> linkNode = NodeInit.initNode();
        System.out.println(LinkNode.printNode(reverse(linkNode)));
    }

    public LinkNode<Integer> reverse(LinkNode<Integer> head) {
        if (head.next == null) {
            return head;
        }
        LinkNode<Integer> last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
