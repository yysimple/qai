package com.simple.algorithm.labuladong.chapter01.tree.serialize;

import com.simple.algorithm.labuladong.common.init.TreeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.*;

/**
 * 功能描述: 前序遍历序列化
 *
 * @author: WuChengXing
 * @create: 2021-11-09 20:39
 **/
public class FrontSerialize extends BaseTest {

    final String NULL_STR = "#";
    final String COMMA = ",";

    @Test
    public void test() {
        String serialize = serialize(TreeInit.initSerialize());
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(TreeNode.printTree(deserialize));
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverseSerialize(root, sb);
        return sb.toString();
    }

    public TreeNode deserialize(String codec) {
        String[] split = codec.split(COMMA);
        ArrayDeque<String> list = new ArrayDeque<>(Arrays.asList(split));
        return traverseDeserialize(list);
    }

    public void traverseSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_STR).append(COMMA);
            return;
        }
        sb.append(root.val).append(COMMA);
        // 前序遍历要做的事情
        traverseSerialize(root.left, sb);
        traverseSerialize(root.right, sb);
    }

    public TreeNode traverseDeserialize(ArrayDeque<String> values) {
        if (values.isEmpty()) {
            return null;
        }
        // 从头开始取出节点
        String rootValue = values.removeFirst();
        if (rootValue.equals(NULL_STR)) {
            return null;
        }
        // 构建当前节点
        TreeNode root = new TreeNode(Integer.parseInt(rootValue));
        // 递归构建左右子树
        root.left = traverseDeserialize(values);
        root.right = traverseDeserialize(values);
        return root;
    }

}
