package com.simple.algorithm.labuladong.common.init;

import com.simple.algorithm.labuladong.common.model.NTreeNode;

/**
 * @author WuChengXing
 * @date 2021/11/10
 */
public class NTreeInit {

    public static NTreeNode initNtTree() {
        NTreeNode nTreeNode_11 = new NTreeNode(1);
        NTreeNode nTreeNode_21 = new NTreeNode(2);
        NTreeNode nTreeNode_22 = new NTreeNode(3);
        NTreeNode nTreeNode_23 = new NTreeNode(4);
        NTreeNode nTreeNode_211 = new NTreeNode(5);
        NTreeNode nTreeNode_212 = new NTreeNode(6);
        NTreeNode nTreeNode_221 = new NTreeNode(7);
        NTreeNode nTreeNode_231 = new NTreeNode(8);
        NTreeNode nTreeNode_232 = new NTreeNode(9);

        NTreeNode[] nTreeNodes_21 = new NTreeNode[2];
        nTreeNodes_21[0] = nTreeNode_211;
        nTreeNodes_21[1] = nTreeNode_212;

        NTreeNode[] nTreeNodes_22 = new NTreeNode[2];
        nTreeNodes_22[0] = nTreeNode_221;

        NTreeNode[] nTreeNodes_23 = new NTreeNode[2];
        nTreeNodes_23[0] = nTreeNode_231;
        nTreeNodes_23[1] = nTreeNode_232;

        NTreeNode[] nTreeNodes_1 = new NTreeNode[3];
        nTreeNodes_1[0] = nTreeNode_21;
        nTreeNodes_1[1] = nTreeNode_22;
        nTreeNodes_1[2] = nTreeNode_23;
        nTreeNode_11.setChildren(nTreeNodes_1);
        nTreeNode_21.setChildren(nTreeNodes_21);
        nTreeNode_22.setChildren(nTreeNodes_22);
        nTreeNode_23.setChildren(nTreeNodes_23);
        return nTreeNode_11;
    }
}
