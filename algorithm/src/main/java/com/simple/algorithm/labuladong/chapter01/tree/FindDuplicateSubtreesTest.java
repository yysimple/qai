package com.simple.algorithm.labuladong.chapter01.tree;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-01 22:38
 **/
public class FindDuplicateSubtreesTest extends BaseTest {

    /**
     * 用于存放不重复的子树
     */
    HashMap<String, Integer> memo = new HashMap<>();

    /**
     * 用来存放最后返回的节点
     */
    LinkedList<String> list = new LinkedList<>();

    @Test
    public void test() {
        System.out.println(findDuplicateSubtrees(TreeInit.initDuplicateTree()));
        System.out.println(list);
    }

    public String findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = findDuplicateSubtrees(root.left);
        String right = findDuplicateSubtrees(root.right);

        String subTree = left + "," + right + root.val;
        int freq = memo.getOrDefault(subTree, 0);
        // 如果已经包含
        if (freq == 1) {
            list.add(subTree);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
