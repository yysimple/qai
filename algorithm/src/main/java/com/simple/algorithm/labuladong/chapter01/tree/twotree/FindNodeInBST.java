package com.simple.algorithm.labuladong.chapter01.tree.twotree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-03 23:34
 **/
public class FindNodeInBST {

    @Test
    public void test() {
        Boolean isExist = testFindNodeInBST(TreeInit.initBST(), 3);
        System.out.println("value is exist in BST ? " + isExist);
    }

    public Boolean testFindNodeInBST(TreeNode root, Integer target) {
        if (root == null) {
            return false;
        }

        // 符合条件的情况
        if (root.val == target) {
            return true;
            // 如果root的值小于目标值，证明最后的结果在右子树
        } else if (root.val < target) {
            return testFindNodeInBST(root.right, target);
            // 反之这里就应该在左子树
        } else {
            return testFindNodeInBST(root.left, target);
        }
    }
}
