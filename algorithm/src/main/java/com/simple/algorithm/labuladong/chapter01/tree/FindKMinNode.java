package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/11/2
 */
public class FindKMinNode {

    /**
     * 最终找到的值
     */
    int res = 0;

    /**
     * 记录走到哪一步
     */
    int rank = 0;

    @Test
    public void test() {
        testFindKMinNode(TreeInit.initBST(), 3);
        System.out.println(res);
    }

    public void testFindKMinNode(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        // 中序遍历方式，找到对应的节点，因为是递增的
        testFindKMinNode(root.left, k);
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        testFindKMinNode(root.right, k);
    }
}
