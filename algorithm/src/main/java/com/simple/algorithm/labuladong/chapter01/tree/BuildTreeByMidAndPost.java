package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.model.TreeNode;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/29
 */
public class BuildTreeByMidAndPost {
    @Test
    public void test() {
        int[] mid = new int[]{9, 3, 15, 20, 7};
        int[] post = new int[]{9, 15, 7, 20, 3};
        System.out.println(buildTree(mid, post).val);
        System.out.println(buildTree(mid, post).left.val);
    }

    public TreeNode buildTree(int[] mid, int[] post) {
        return build(mid, 0, mid.length - 1, post, 0, post.length - 1);
    }

    public TreeNode build(int[] mid, int midStart, int midEnd, int[] post, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        int rootValue = post[postEnd];
        int midRootIndex = 0;
        for (int i = midStart; i <= midEnd; i++) {
            if (mid[i] == rootValue) {
                midRootIndex = i;
                break;
            }
        }

        int rightNum = midEnd - midRootIndex;

        TreeNode root = new TreeNode(rootValue);
        root.left = build(mid, midStart, midRootIndex - 1,
                post, postStart, postEnd - rightNum - 1);
        root.right = build(mid, midRootIndex + 1, midEnd,
                post, postEnd - rightNum, postEnd - 1);
        return root;
    }
}
