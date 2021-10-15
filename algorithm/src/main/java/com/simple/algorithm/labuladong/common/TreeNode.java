package com.simple.algorithm.labuladong.common;

import lombok.Data;

/**
 * @author WuChengXing
 * @date 2021/10/15
 */
@Data
public class TreeNode<T> {
    TreeNode<T> left;
    TreeNode<T> right;
    T val;

    public TreeNode(TreeNode<T> left, TreeNode<T> right, T val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
