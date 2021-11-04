package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-04 22:53
 **/
public class NumBST extends BaseTest {

    int[][] memo;

    @Test
    public void test() {
        System.out.println(numBST(1, 10));
//        System.out.println(numTrees(10));
    }

    public int numBST(int low, int high) {
        if (low > high) {
            return 1;
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            // 剔除根节点
            int left = numBST(low, i - 1);
            int right = numBST(i + 1, high);
            res += left * right;
        }
        return res;
    }

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    public int count(int low, int high) {
        if (low > high) {
            return 1;
        }

        if (memo[low][high] != 0) {
            return memo[low][high];
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            // 剔除根节点
            int left = numBST(low, i - 1);
            int right = numBST(i + 1, high);
            res += left * right;
        }
        memo[low][high] = res;
        return res;
    }

}
