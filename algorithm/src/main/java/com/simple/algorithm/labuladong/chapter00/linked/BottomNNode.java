package com.simple.algorithm.labuladong.chapter00.linked;

import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import static com.simple.algorithm.labuladong.chapter00.linked.init.NodeInit.initNode;

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
}
