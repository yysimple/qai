package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/11/12
 */
public class AddFullTree extends BaseTest {

    @Test
    public void test() {
        System.out.println(countNodes(TreeInit.initFullTree()));
    }

    /**
     * 统计完全二叉树节点数量
     * 完全二叉树：每一层都是紧凑靠左排列的
     * 满二叉树：都有二个子节点
     * 普通二叉树：随机
     *
     * @param root
     */
    public Integer countNodes(TreeNode root) {
        TreeNode left = root, right = root;
        int treeLeftHigh = 0;
        int treeRightHigh = 0;
        if (root == null) {
            return 0;
        }
        while (left != null) {
            left = left.left;
            treeLeftHigh++;
        }
        while (right != null) {
            right = right.right;
            treeRightHigh++;
        }
        if (treeLeftHigh == treeRightHigh) {
            return (int) Math.pow(2, treeLeftHigh) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
