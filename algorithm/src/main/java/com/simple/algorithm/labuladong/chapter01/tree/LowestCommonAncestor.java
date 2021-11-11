package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/11/11
 */
public class LowestCommonAncestor extends BaseTest {

    @Test
    public void test() {

    }

    /**
     * 寻找公共最近的祖先
     * 利用后序遍历，从下往上的方式遍历，所以最后找到的就是最近的
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode testLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 最开始，也是结束的标识的情况：root为空，root即是p和q -- 递归里面的 root 也可能是子树中的 root 不能跟刚传进来的混为一谈
        if (root == null) {
            return null;
        }
        // 只要有一个是以root为根的，那么祖先一定是 root
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = testLowestCommonAncestor(root.left, p, q);
        TreeNode right = testLowestCommonAncestor(root.right, p, q);
        // 两者都不为空，则返回Root
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }
}
