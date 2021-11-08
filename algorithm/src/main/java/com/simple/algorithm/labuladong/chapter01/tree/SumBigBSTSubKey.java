package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-08 20:24
 **/
public class SumBigBSTSubKey extends BaseTest {

    int maxSum;

    @Test
    public void test() {
        int[] traverse = traverse(TreeInit.init2());
        System.out.println(traverse[3]);
        System.out.println(maxSum);
    }

    /**
     * 功能描述: 节省空间的做法，用int[] 来存储中间的一些临时变量
     * int[0]: 用来记录BST是否合法，0表示非法，1表示合法
     * int[1]: 用来记录以Root为根节点的最小值
     * int[2]: 用来记录以Root为根节点的最大值
     * int[3]: 用来记录最后的计算和
     *
     * @param root
     * @return int[]
     * @author WuChengxing
     * @date 2021/11/8
     */

    public int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] {
                    1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            };
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        /******* 后序遍历位置 *******/
        int[] res = new int[4];
        // 校验其是否合法
        if (left[0] == 1 && right[0] == 1 && left[2] < root.val && right[1] > root.val) {
            // 1. 设置其合法
            res[0] = 1;
            // 2. 求最小值
            res[1] = Math.min(left[1], root.val);
            // 3. 求最大值
            res[2] = Math.max(right[2], root.val);
            // 求和
            res[3] = root.val + left[3] + right[3];
            maxSum = Math.max(maxSum, res[3]);
        } else {
            // 直接置为不合法，不处理
            res[0] = 0;
        }
        return res;
    }

    /**
     * 校验 BST 是否合法
     *
     * @param root
     * @return
     */
    public Boolean isBst(TreeNode root) {
        if (root == null) {
            return null;
        }
        return checkBST(root, null, null);
    }

    public Boolean checkBST(TreeNode root, TreeNode min, TreeNode max) {
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return checkBST(root.left, min, root) && checkBST(root.right, root, max);
    }
}
