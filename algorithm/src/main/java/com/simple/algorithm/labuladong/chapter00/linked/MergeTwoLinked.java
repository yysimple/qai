package com.simple.algorithm.labuladong.chapter00.linked;

import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * 合并两个有序链表
 *
 * @author WuChengXing
 * @date 2021/10/19
 */
public class MergeTwoLinked extends BaseTest {

    @Test
    public void test() {
        LinkNode<Integer> l1_2 = new LinkNode<>(null, 6);
        LinkNode<Integer> l1_1 = new LinkNode<>(l1_2, 4);
        LinkNode<Integer> l1_head = new LinkNode<>(l1_1, 1);

        LinkNode<Integer> l2_2 = new LinkNode<>(null, 5);
        LinkNode<Integer> l2_1 = new LinkNode<>(l2_2, 4);
        LinkNode<Integer> l2_head = new LinkNode<>(l2_1, 3);
        LinkNode<Integer> linkNode = testMergeTwoLinked(l1_head, l2_head);
        System.out.println(linkNode);
    }

    public LinkNode<Integer> testMergeTwoLinked(LinkNode<Integer> l1, LinkNode<Integer> l2) {
        LinkNode<Integer> vHead = new LinkNode<>(null, -1);
        LinkNode<Integer> p = vHead;
        LinkNode<Integer> linkNodeOne = l1;
        LinkNode<Integer> linkNodeTwo = l2;
        while (linkNodeOne != null && linkNodeTwo != null) {
            if (linkNodeOne.val > linkNodeTwo.val) {
                p.next = linkNodeTwo;
                linkNodeTwo = linkNodeTwo.next;
            } else {
                p.next = linkNodeOne;
                linkNodeOne = linkNodeOne.next;
            }
            p = p.next;
        }
        // 最小的那个数 所在节点的赋值判断，这里是 val = 6的节点拼接上去
        if (linkNodeOne != null) {
            p.next = linkNodeOne;
        }
        if (linkNodeTwo != null) {
            p.next = linkNodeTwo;
        }
        return vHead.next;
    }
}
