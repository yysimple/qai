package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-02 23:31
 **/
public class BSTConvert2AddTree extends BaseTest {

    @Test
    public void test() {
        TreeNode treeNode = TreeInit.initBST();
        convertBST(treeNode);
        System.out.println(treeNode);
    }

    TreeNode convertBST(TreeNode root) {
        testBSTConvert2AddTree(root);
        return root;
    }

    int sum = 0;
    public void testBSTConvert2AddTree(TreeNode root) {
        if (root == null) {
            return;
        }

        testBSTConvert2AddTree(root.right);
        sum += root.val;
        root.val = sum;
        testBSTConvert2AddTree(root.left);
    }

}
