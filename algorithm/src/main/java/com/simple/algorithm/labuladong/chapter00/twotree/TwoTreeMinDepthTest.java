package com.simple.algorithm.labuladong.chapter00.twotree;

import com.simple.algorithm.labuladong.common.TreeNode;
import com.simple.algorithm.test.BaseTest;
import lombok.Data;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuChengXing
 * @date 2021/10/15
 */
public class TwoTreeMinDepthTest extends BaseTest {
    @Test
    public void testMinDepth() {
        int i = minDepth(init());
        System.out.println("最小深度：" + i);
    }

    /**
     * 最小深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode<Integer> root) {
        if (root == null) return 0;
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode<Integer> cur = q.poll();
                /* 判断是否到达终点 */
                if (cur.getLeft() == null && cur.getRight() == null)
                    return depth;
                /* 将 cur 的相邻节点加入队列 */
                if (cur.getLeft() != null)
                    q.offer(cur.getLeft());
                if (cur.getRight() != null)
                    q.offer(cur.getRight());
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }

    public TreeNode<Integer> init() {
        TreeNode<Integer> node15 = new TreeNode<>(null, null, 15);
        TreeNode<Integer> node7 = new TreeNode<>(null, null, 7);
        TreeNode<Integer> node20 = new TreeNode<>(node15, node7, 20);
        TreeNode<Integer> node9 = new TreeNode<>(null, null, 9);
        TreeNode<Integer> root = new TreeNode<>(node9, node20, 3);
        return root;
    }
}
