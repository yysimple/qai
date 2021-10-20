package com.simple.algorithm.labuladong.chapter00.linked;

import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * 找到倒数第N个节点
 *
 * @author WuChengXing
 * @date 2021/10/20
 */
public class BottomNNode extends BaseTest {

    @Test
    public void test() {
        System.out.println(findBottomNNode(initNode(), 2).val);
    }

    /**
     * 其实是快慢指针的方式
     *
     * @param root
     * @param n
     * @return
     */
    public LinkNode<Integer> findBottomNNode(LinkNode<Integer> root, int n) {
        LinkNode<Integer> node1 = root;
        LinkNode<Integer> node2 = root;
        for (int i = 0; i < n; i++) {
            node1 = node1.next;
        }
        while (node1 != null) {
            node2 = node2.next;
            node1 = node1.next;
        }
        return node2;
    }

    public LinkNode<Integer> initNode() {
        LinkNode<Integer> l2_4 = new LinkNode<>(null, 9);
        LinkNode<Integer> l2_3 = new LinkNode<>(l2_4, 5);
        LinkNode<Integer> l2_2 = new LinkNode<>(l2_3, 4);
        LinkNode<Integer> l2_1 = new LinkNode<>(l2_2, 3);
        LinkNode<Integer> l2_head = new LinkNode<>(l2_1, 1);
        return l2_head;
    }
}
