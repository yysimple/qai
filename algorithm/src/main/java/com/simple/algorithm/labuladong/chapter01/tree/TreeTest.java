package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-10-23 09:56
 **/
public class TreeTest {
    @Test
    public void test() {
        TreeNode treeNode = TreeInit.initTreeFull();
        printTreeFront(treeNode);
        System.out.println("-----------");
        printTreeBack(treeNode);
        System.out.println("-----------");
        printTreeMid(treeNode);
    }

    /**
     * 前序遍历：1->2->4->5->3->6->7
     * 这里就是将“打印逻辑”放在递归之前，所以叫前序遍历，要注意以下几点：
     *  - 从root开始打印的
     *  - 根据 treeNode.left 和 treeNode.right 的顺序决定第二个元素是谁先打印（这里建议先看画好的树结构，在进行对比的看）
     *      1. treeNode.left在前：先打印左边   1->2->4->5->3->6->7
     *      2. treeNode.right在前，先打印右边  1->3->7->6->2->5->4
     *
     *
     * @param treeNode
     */
    public void printTreeFront(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        printTreeFront(treeNode.left);
        printTreeFront(treeNode.right);
    }

    /**
     * 后序遍历：4->5->2->6->7->3->1
     *
     * 这里跟上面的就是反着来，先从叶子节点遍历，然后一直往上，这里left和right的顺序也是会影响的
     * 还是参照图看，反过来就是 7->6->3->5->4->2->1
     *
     * 这里可以自己把这个顺序连冠的对着画出来的图  连一便 ，就有感觉了
     *
     * @param treeNode
     */
    public void printTreeBack(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printTreeBack(treeNode.right);
        printTreeBack(treeNode.left);
        System.out.println(treeNode.val);
    }

    /**
     * 中序遍历：4->2->5->1->6->3->7 逆转一下就行了
     *
     * @param treeNode
     */
    public void printTreeMid(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printTreeMid(treeNode.right);
        System.out.println(treeNode.val);
        printTreeMid(treeNode.left);

    }
}
