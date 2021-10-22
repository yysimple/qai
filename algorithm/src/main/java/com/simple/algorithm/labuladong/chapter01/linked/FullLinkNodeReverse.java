package com.simple.algorithm.labuladong.chapter01.linked;

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
        // 以头结点的下一个节点为遍历目标，当下一个节点没有值的时候，也即head已经来到尾部了
        if (head.next == null) {
            return head;
        }
        // 这里已经拿到了反转后的最后一个节点
        LinkNode<Integer> last = reverse(head.next);
        // 可以理解这里为交换位置，其实就是反转
        head.next.next = head;
        // 最后将头节点的下一个节点置空
        head.next = null;
        // 返回最后一个节点，也即是新的头结点
        return last;
    }
}
