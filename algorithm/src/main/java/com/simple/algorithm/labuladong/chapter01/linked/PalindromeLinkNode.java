package com.simple.algorithm.labuladong.chapter01.linked;

import com.simple.algorithm.labuladong.common.init.NodeInit;
import com.simple.algorithm.labuladong.common.model.LinkNode;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/25
 */
public class PalindromeLinkNode {
    @Test
    public void test() {
        System.out.println(isPalindrome(NodeInit.initNodePalindrome()));
    }

    LinkNode<Integer> left = null;

    public boolean isPalindrome(LinkNode<Integer> head) {
        left = head;
        return isPalindromeLinkNode(left);
    }

    /**
     * 判断是否是回文链表（不是回文串）
     *
     * @param right
     * @return
     */
    public boolean isPalindromeLinkNode(LinkNode<Integer> right) {
        if (right == null) {
            return true;
        }
        boolean res = isPalindromeLinkNode(right.next);
        // 后序遍历
        res = res && (left.val.equals(right.val));
        // 指针后移
        left = left.next;
        return res;
    }

}
