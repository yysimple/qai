package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/26
 */
public class FillTwoTree extends BaseTest {

    @Test
    public void test() {
        System.out.println(TreeNode.printTree(testFillTwoTree(TreeInit.initTree())));
    }

    public TreeNode testFillTwoTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        testFillTwoTreeDetail(root.left, root.right);
        return root;
    }

    public void testFillTwoTreeDetail(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        /**
         * 这三步是进行了所有节点的遍历
         */
        // 前两步是进行左右子树的递归
        testFillTwoTreeDetail(left.left, left.right);
        testFillTwoTreeDetail(right.left, right.right);
        // 这个是进行跨树关联
        testFillTwoTreeDetail(left.right, right.left);
    }
}
