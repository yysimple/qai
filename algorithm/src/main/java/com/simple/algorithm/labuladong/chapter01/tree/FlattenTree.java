package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.init.NodeInit;
import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/26
 */
public class FlattenTree extends BaseTest {

    @Test
    public void test() {
        TreeNode treeNode = TreeInit.initTree();
        testFlattenTree(treeNode);
        System.out.println(TreeNode.printTree(treeNode));
    }

    public void testFlattenTree(TreeNode root) {
        if (root == null) {
            return;
        }
        testFlattenTree(root.left);
        testFlattenTree(root.right);

        // 后序遍历
        // 1. 将两个子树都转换成链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2. 将左子树作为右子树
        root.left = null;
        root.right = left;

        // 拼接剩下来的右子树
        TreeNode remRight = root;
        while (remRight.right != null) {
            remRight = remRight.right;
        }
        remRight.right = right;
    }
}
