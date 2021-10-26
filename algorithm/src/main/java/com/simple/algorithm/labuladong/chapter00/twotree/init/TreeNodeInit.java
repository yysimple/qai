package com.simple.algorithm.labuladong.chapter00.twotree.init;

import com.simple.algorithm.labuladong.common.model.TreeNode;

/**
 * @author WuChengXing
 * @date 2021/10/15
 */
public class TreeNodeInit {

    public static TreeNode init1() {
        TreeNode node15 = new TreeNode(null, null, 15);
        TreeNode node7 = new TreeNode(null, null, 7);
        TreeNode node20 = new TreeNode(node15, node7, 20);
        TreeNode node9 = new TreeNode(null, null, 9);
        TreeNode root = new TreeNode(node9, node20, 3);
        return root;
    }
}
