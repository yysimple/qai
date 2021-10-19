package com.simple.algorithm.labuladong.chapter00.twotree;

import com.simple.algorithm.labuladong.chapter00.twotree.init.TreeNodeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuChengXing
 * @date 2021/10/15
 */
public class MyTwoTreeMinDepth {

    @Test
    public void testMinDepth() {
        System.out.println(minDepth(TreeNodeInit.init1()));
    }

    public int minDepth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> curr = queue.poll();
                if (curr.getLeft() == null && curr.getRight() == null) {
                    return depth;
                }
                if (curr.getLeft() != null) {
                    queue.offer(curr.getLeft());
                }
                if (curr.getRight() != null) {
                    queue.offer(curr.getRight());
                }
                depth++;
            }
        }
        return 1;
    }
}
