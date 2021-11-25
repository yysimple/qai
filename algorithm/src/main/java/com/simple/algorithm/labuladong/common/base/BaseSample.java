package com.simple.algorithm.labuladong.common.base;

import com.simple.algorithm.labuladong.common.model.Graph;
import com.simple.algorithm.labuladong.common.model.NTreeNode;
import com.simple.algorithm.labuladong.common.model.TreeNode;

/**
 * 功能描述: 基本数据结构的刷题思路
 *
 * @author: WuChengXing
 * @create: 2021-11-25 22:13
 **/
public class BaseSample {

    /**
     * 二叉树的模板
     *
     * @param node
     */
    private void traverseTwoTree(TreeNode node) {
        if (node == null) {
            return;
        }
        // 前序遍历
        traverseTwoTree(node.left);
        // 中序遍历
        traverseTwoTree(node.right);
        // 后序遍历

    }

    /**
     * N叉树的遍历
     *
     * @param node
     */
    private void traverseNTree(NTreeNode node) {
        if (node == null) {
            return;
        }
        for (NTreeNode child : node.getChildren()) {
            traverseNTree(child);
        }
    }

    /**
     * 图的遍历
     */
    boolean[] visited;

    private void traverseGraph(Graph graph, int node) {
        if (visited[node]) {
            return;
        }
        for (TreeNode treeNode : graph.getNeighbors()[node]) {
            traverseGraph(graph, treeNode.getVal());
        }

    }
}
