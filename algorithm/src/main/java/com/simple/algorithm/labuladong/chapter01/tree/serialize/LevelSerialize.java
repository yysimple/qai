package com.simple.algorithm.labuladong.chapter01.tree.serialize;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-09 22:05
 **/
public class LevelSerialize extends BaseTest {

    final String NULL_STR = "#";
    final String COMMA = ",";

    @Test
    public void test() {
        // traverse(TreeInit.initSerialize());
        String serialize = serialize(TreeInit.initSerialize());
        System.out.println(serialize);
        System.out.println(TreeNode.printTree(deserialize(serialize)));
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append(NULL_STR).append(COMMA);
                continue;
            }
            sb.append(curr.val).append(COMMA);
            // 遍历
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] split = data.split(COMMA);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.offer(root);
        for (int i = 1; i < split.length; ) {
            TreeNode parent = queue.poll();
            String left = split[i++];
            if (!left.equals(NULL_STR)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            } else {
                parent.left = null;
            }
            String right = split[i++];
            if (!right.equals(NULL_STR)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }

    public void traverse(TreeNode root) {
        if (root == null) return;
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            /* 层级遍历代码位置 */
            System.out.println(cur.val);
            /*****************/


            if (cur.left != null) {
                q.offer(cur.left);
            }

            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }
}
