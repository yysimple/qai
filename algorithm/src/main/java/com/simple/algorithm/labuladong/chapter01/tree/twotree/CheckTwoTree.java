package com.simple.algorithm.labuladong.chapter01.tree.twotree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-03 23:00
 **/
public class CheckTwoTree extends BaseTest {

    @Test
    public void test() {
        Boolean valid = isValid(TreeInit.initBST(), null, null);
        System.out.println("is standard BST ? " + valid);
    }

    public Boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        // 这里借助连个辅助的节点，来模拟最大边界和最小边界
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 这里的话，对于左子树，最大的值应该不能大于root节点的值，对于右子树来说，最小值应该不能小于root的值
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
}
