package com.simple.algorithm.labuladong.common.init;

import com.simple.algorithm.labuladong.common.model.TreeNode;

/**
 * @author WuChengXing
 * @date 2021/10/26
 */
public class TreeInit {

    public static TreeNode initTreeFull() {
        TreeNode r3 = new TreeNode(null, null, 7);
        TreeNode r2 = new TreeNode(null, null, 6);
        TreeNode r1 = new TreeNode(r2, r3, 3);
        TreeNode l3 = new TreeNode(null, null, 5);
        TreeNode l2 = new TreeNode(null, null, 4);
        TreeNode l1 = new TreeNode(l2, l3, 2);
        TreeNode root = new TreeNode(l1, r1, 1);
        return root;
    }

    public static TreeNode initTree() {
        TreeNode r3 = new TreeNode(null, null, 6);
        TreeNode r1 = new TreeNode(null, r3, 5);
        TreeNode l3 = new TreeNode(null, null, 4);
        TreeNode l2 = new TreeNode(null, null, 3);
        TreeNode l1 = new TreeNode(l2, l3, 2);
        TreeNode root = new TreeNode(l1, r1, 1);
        return root;
    }

    public static TreeNode initDuplicateTree() {
        TreeNode r4 = new TreeNode(null, null, 4);
        TreeNode r3 = new TreeNode(null, null, 4);
        TreeNode r2 = new TreeNode(r4, null, 2);
        TreeNode r1 = new TreeNode(r2, r3, 3);
        TreeNode l2 = new TreeNode(null, null, 4);
        TreeNode l1 = new TreeNode(l2, null, 2);
        TreeNode root = new TreeNode(l1, r1, 1);
        return root;
    }
}

