package com.simple.algorithm.labuladong.chapter01.tree.ntree;

import com.simple.algorithm.labuladong.common.init.NTreeInit;
import com.simple.algorithm.labuladong.common.model.NTreeNode;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/11/10
 */
public class NTreeTest {

    @Test
    public void test() {
        NTreeNode nTreeNode = NTreeInit.initNtTree();
        System.out.println();
        traverse(nTreeNode);
    }

    public void traverse(NTreeNode nTreeNode) {
        if (nTreeNode == null || nTreeNode.getChildren() == null) {
            return;
        }
        for (NTreeNode child : nTreeNode.getChildren()) {
            System.out.println("child val: " + child.getVal());
            traverse(child);
        }
    }

}
