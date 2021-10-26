package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/26
 */
public class FlipFullTree extends BaseTest {

    @Test
    public void test() {
        System.out.println(TreeNode.printTree(testFlipFullTree(TreeInit.initTreeFull())));
    }

    /**
     * 使用前序遍历，然后交换一下位置即可
     *
     * @param root
     * @return
     */
    public TreeNode testFlipFullTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        testFlipFullTree(root.left);
        testFlipFullTree(root.right);
        return root;
    }
}
