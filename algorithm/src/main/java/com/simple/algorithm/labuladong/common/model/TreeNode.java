package com.simple.algorithm.labuladong.common.model;

import lombok.Data;

/**
 * 二叉树基本结构
 *
 * @author WuChengXing
 * @date 2021/10/15
 */
@Data
public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T val;

    /**
     * 适用于树结构，双向链表
     *
     * @param left
     * @param right
     * @param val
     */
    public TreeNode(TreeNode<T> left, TreeNode<T> right, T val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    /**
     * 单向链表
     *
     * @param right
     * @param val
     */
    public TreeNode(TreeNode<T> right, T val) {
        this.right = right;
        this.val = val;
    }
}
