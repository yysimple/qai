package com.simple.algorithm.labuladong.chapter00.linked;

import com.simple.algorithm.labuladong.common.model.LinkNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/20
 */
public class RemoveBottomNNode extends BaseTest {

    BottomNNode bottomNNode = new BottomNNode();

    @Test
    public void test() {
        LinkNode<Integer> linkNode = bottomNNode.initNode();
        LinkNode<Integer> linkNode1 = removeBottomNNode(linkNode, 2);
        System.out.println(linkNode1);
    }

    public LinkNode<Integer> removeBottomNNode(LinkNode<Integer> root, int n) {
        LinkNode<Integer> vHead;
        vHead = root;
        LinkNode<Integer> bottomNNode1 = bottomNNode.findBottomNNode(vHead, n + 1);
        // 删除操作
        bottomNNode1.next = bottomNNode1.next.next;
        return vHead;
    }
}
