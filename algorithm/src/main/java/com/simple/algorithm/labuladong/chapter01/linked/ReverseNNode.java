package com.simple.algorithm.labuladong.chapter01.linked;

import com.simple.algorithm.labuladong.common.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/22
 */
public class ReverseNNode {

    @Test
    public void test() {
        System.out.println(reverseNNode(NodeInit.initNode(), 1).val);
    }

    LinkNode<Integer> tmpNode = null;

    public LinkNode<Integer> reverseNNode(LinkNode<Integer> head, int n) {
        // 如果是 1 那就是head直接返回
        if (n == 1) {
            tmpNode = head.next;
            return head;
        }
        // 这里是以 head.next 开始的，所以后面应该是 n - 1
        LinkNode<Integer> last = reverseNNode(head.next, n - 1);
        head.next.next = head;
        // 这里最后一个节点就是不变的那个节点，也即是反转之后指向的那个节点
        head.next = tmpNode;
        return last;
    }
}
