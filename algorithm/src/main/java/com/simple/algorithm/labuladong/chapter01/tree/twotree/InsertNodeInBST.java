package com.simple.algorithm.labuladong.chapter01.tree.twotree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-03 23:45
 **/
public class InsertNodeInBST {

    @Test
    public void test() {
        TreeNode treeNode = testInsertNodeInBST(TreeInit.initBST(), 9);
        System.out.println(treeNode);
    }

    public TreeNode testInsertNodeInBST(TreeNode root, Integer val) {
        // root为空，则构建一个以val为root的新的BST
        if (root == null) {
            return new TreeNode(val);
        }
        // 这里插入一个已经存在的值毫无意义
        if (root.val < val) {
            root.right = testInsertNodeInBST(root.right, val);
        }
        if (root.val > val) {
            root.left = testInsertNodeInBST(root.left, val);
        }
        return root;
    }
}
