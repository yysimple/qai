package com.simple.algorithm.labuladong.chapter00.twotree.init;

import com.simple.algorithm.labuladong.common.TreeNode;

/**
 * @author WuChengXing
 * @date 2021/10/15
 */
public class TreeNodeInit {

    public static TreeNode<Integer> init1() {
        TreeNode<Integer> node15 = new TreeNode<>(null, null, 15);
        TreeNode<Integer> node7 = new TreeNode<>(null, null, 7);
        TreeNode<Integer> node20 = new TreeNode<>(node15, node7, 20);
        TreeNode<Integer> node9 = new TreeNode<>(null, null, 9);
        TreeNode<Integer> root = new TreeNode<>(node9, node20, 3);
        return root;
    }
}
