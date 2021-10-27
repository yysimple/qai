package com.simple.algorithm.labuladong.common.model;

import lombok.Data;

/**
 * 二叉树基本结构
 *
 * @author WuChengXing
 * @date 2021/10/15
 */
@Data
public class TreeNode {
    public TreeNode next;
    public TreeNode left;
    public TreeNode right;
    public int val;

    /**
     * 适用于树结构，双向链表
     *
     * @param left
     * @param right
     * @param val
     */
    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 单向链表
     *
     * @param right
     * @param val
     */
    public TreeNode(TreeNode right, int val) {
        this.right = right;
        this.val = val;
    }

    static StringBuilder sb = new StringBuilder("start->");

    /**
     * 前序遍历，left -> right 的形式
     * @param root
     * @return
     */
    public static String printTree(TreeNode root) {
        if (root == null) {
            return "";
        }
        sb.append(root.val).append("->");
        printTree(root.left);
        printTree(root.right);
        return sb.toString();
    }
}
