package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-05 22:46
 **/
public class BuildSubBST extends BaseTest {

    @Test
    public void test() {
        System.out.println(generateTrees(3));
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int low, int high) {
        // 返回值初始化
        List<TreeNode> res = new LinkedList<>();
        // 结束值
        if (low > high) {
            res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> left = build(low, i - 1);
            List<TreeNode> right = build(i + 1, high);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    // 构建root节点
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }


}
