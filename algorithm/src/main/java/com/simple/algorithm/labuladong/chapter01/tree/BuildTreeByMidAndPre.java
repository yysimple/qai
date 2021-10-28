package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.model.TreeNode;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/28
 */
public class BuildTreeByMidAndPre {

    @Test
    public void test() {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] mid = new int[]{9, 3, 15, 20, 7};
        System.out.println(buildTree(pre, mid).val);
    }

    public TreeNode buildTree(int[] pre, int[] mid) {
        return build(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
    }

    private TreeNode build(int[] pre, int preStart, int preEnd, int[] mid, int midStart, int midEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootValue = pre[preStart];
        // 用判断mid的root的索引
        int index = 0;
        for (int i = 0; i <= midEnd; i++) {
            if (mid[i] == rootValue) {
                index = i;
                break;
            }
        }
        // 前序遍历的左节点个数
        int leftSize = index - preStart;

        TreeNode root = new TreeNode(rootValue);
        // 因为不加 root 所以 pre的位置 + 1，mid的不加，但是最后邻近root 所以 -1
        root.left = build(pre, preStart + 1, preStart + leftSize,
                mid, midStart, index - 1);
        root.right = build(pre, preStart + leftSize + 1, preEnd,
                mid, index + 1, midEnd);
        return root;
    }
}
