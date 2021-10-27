package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/27
 */
public class MaxTree extends BaseTest {

    @Test
    public void test() {
        TreeNode root = buildMaxTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(TreeNode.printTree(root));
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.left.right.val);

    }

    public TreeNode buildMaxTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        // 找到最大值/和最大值的索引
        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for (int i = low; i <= high; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        // 构建根节点
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, high);
        return root;
    }

}

