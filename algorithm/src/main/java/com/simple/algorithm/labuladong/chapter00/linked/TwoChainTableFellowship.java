package com.simple.algorithm.labuladong.chapter00.linked;

import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/20
 */
public class TwoChainTableFellowship extends BaseTest {

    @Test
    public void test() {
        LinkNode<Integer> c2 = new LinkNode<>(null, 11);
        LinkNode<Integer> c1 = new LinkNode<>(c2, 9);
        LinkNode<Integer> a2 = new LinkNode<>(c1, 7);
        LinkNode<Integer> a1 = new LinkNode<>(a2, 1);

        LinkNode<Integer> b3 = new LinkNode<>(c1, 4);
        LinkNode<Integer> b2 = new LinkNode<>(b3, 3);
        LinkNode<Integer> b1 = new LinkNode<>(b2, 2);

        LinkNode<Integer> linkNode = twoChainTableFellowship(a1, b1);
        System.out.println(linkNode);
    }

    /**
     * 判断链表是否相交:
     *  两个指针 P1 和 P2
     *  分别遍历不同的链表，遍历完之后 交换一下，继续遍历，那么最后一个节点一定是 第一个相交的节点
     *
     * @param node1
     * @param node2
     * @return
     */
    public LinkNode<Integer> twoChainTableFellowship(LinkNode<Integer> node1, LinkNode<Integer> node2) {
        LinkNode<Integer> p1 = node1;
        LinkNode<Integer> p2 = node2;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = node2;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = node1;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

}
