package com.simple.algorithm.labuladong.chapter01.tree.twotree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-03 23:59
 **/
public class DeleteNodeInBST {

    @Test
    public void test() {
        System.out.println(testDeleteNodeInBST(TreeInit.initBST(), 2));
    }

    /**
     * 最后两部操作都可以直接成固定公式了，但是还是有点不一样；
     * 拿前面的，在BST中判断一个元素是否存在，还有判断是否是合法的BST，那里是直接return掉的；
     * 那是因为，当走到那个步骤，也就是对比找到的节点的值与目标值是否符合，就可以停止
     * 而需要返回值的时候，我们需要修改树的结构，所以root的左右子树是需要去变化的，所以应该使用root.right等去递归，找到对应节点修改
     * 就像是去记录到哪个节点，或者哪个关联节点需要修改
     *
     * @param root
     * @param target
     * @return
     */
    public TreeNode testDeleteNodeInBST(TreeNode root, Integer target) {
        if (root == null) {
            return null;
        }
        // 找到要删除的值
        if (root.val == target) {
            // 这里如果左边的为空，证明只存在右子树，所以直接右子树顶上就行
            if (root.left == null) {
                return root.right;
            }
            // 这里道理一致
            if (root.right == null) {
                return root.left;
            }
            // 这里就先去判断，拿到该节点的右子树最小的值？因为往上顶的肯定会在右子树上，且会是右子树最小的值
            TreeNode min = getMin(root.right);
            // 先把这个值赋给新的顶替的节点
            root.val = min.val;
            // 这里根据上面的规则，去删除最后那个最小的节点
            root.right = testDeleteNodeInBST(root.right, min.val);
        } else if (root.val < target) {
            root.right = testDeleteNodeInBST(root.right, target);
        } else {
            root.left = testDeleteNodeInBST(root.left, target);
        }
        return root;
    }

    /**
     * 获取BST的最小节点
     *
     * @param root
     * @return
     */
    public TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
