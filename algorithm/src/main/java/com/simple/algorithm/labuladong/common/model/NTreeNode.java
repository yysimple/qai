package com.simple.algorithm.labuladong.common.model;

import lombok.Data;

/**
 * @author WuChengXing
 * @date 2021/11/10
 */
@Data
public class NTreeNode {
    private Integer val;
    private NTreeNode[] children;

    public NTreeNode() {
    }

    public NTreeNode(Integer val) {
        this.val = val;
    }

    public NTreeNode(NTreeNode[] children) {
        this.children = children;
    }
}
