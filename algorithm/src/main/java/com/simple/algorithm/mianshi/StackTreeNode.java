package com.simple.algorithm.mianshi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 功能描述: 基于栈的二叉树
 *
 * @author: WuChengXing
 * @create: 2022-01-24 21:13
 **/
public class StackTreeNode {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    /**
     * 新增一个节点
     *
     * @param val
     * @return
     */
    public boolean insertNode(int val) {
        // 构建一个节点
        TreeNode treeNode = new TreeNode(val);
        // 当前root为空，则构建root
        if (root == null) {
            root = treeNode;
            return true;
        } else {
            TreeNode curr = root;
            while (true) {
                // 小于根节点的值，往左走，反之往右走
                if (curr.val > val) {
                    if (curr.left == null) {
                        curr.left = treeNode;
                        return true;
                    }
                    curr = curr.left;
                } else if (curr.val < val) {
                    if (curr.right == null) {
                        curr.right = treeNode;
                        return true;
                    }
                    curr = curr.right;
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                System.out.println(curr.val);
                stack.push(curr);
                // 遍历左节点
                curr = curr.left;
            }
            // 类似回退操作，拿到对应的右节点，看起是否还存在左节点
            curr = stack.pop();
            curr = curr.right;
        }
    }

    /**
     * 中序：这里就是将输出放在回退到右节点前打印即可
     *
     * @param root
     */
    public void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    /**
     * 使用双栈的方式一个进行存储，一个用来方便遍历
     *
     * @param root
     */
    private void doubleStackPostOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> storeStack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                storeStack.push(cur);
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;
        }
        // 遍历存储栈
        int n = storeStack.size();
        for (int i = 0; i < n; i++) {
            System.out.println(storeStack.pop().val);
        }
    }

    /**
     * 后序，单栈标记法
     *
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 标识是否已经出栈
        TreeNode t = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }//cur.left==null
            // 取栈顶元素
            cur = stack.peek();
            // 右子树为空或者右子树已经处理过
            if (cur.right == null || t == cur.right) {
                // 出栈，标识是否已经处理过
                t = stack.pop();
                System.out.println(t.val);
                cur = null;
            } else {
                cur = cur.right;
            }

        }
    }


    public void preOrderDG(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val);
        preOrderDG(node.left);
        preOrderDG(node.right);
    }

    static void midOrderDG(TreeNode node) {
        if (node == null)
            return;
        midOrderDG(node.left);
        System.out.print(node.val);
        midOrderDG(node.right);
    }

    static void postOrderDG(TreeNode node) {
        if (node == null)
            return;
        postOrderDG(node.left);
        postOrderDG(node.right);
        System.out.print(node.val);
    }


    public StackTreeNode initTreeNode() {
        StackTreeNode treeNode = new StackTreeNode();
        int[] a = {2, 5, 1, 3, 9, 8, 7, 4, 6};
        for (int i = 0; i < a.length; i++) {
            treeNode.insertNode(a[i]);
        }
        return treeNode;
    }

    @Test
    public void testPreOrder() {
        StackTreeNode treeNode = initTreeNode();
        treeNode.preOrder(treeNode.root);
    }

    @Test
    public void testMidOrder() {
        StackTreeNode treeNode = initTreeNode();
        treeNode.midOrder(treeNode.root);
    }

    @Test
    public void testDoubleStackPostOrder() {
        StackTreeNode treeNode = initTreeNode();
        treeNode.doubleStackPostOrder(treeNode.root);
    }

    @Test
    public void testPostOrder() {
        StackTreeNode treeNode = initTreeNode();
        treeNode.postOrder(treeNode.root);
    }
}
