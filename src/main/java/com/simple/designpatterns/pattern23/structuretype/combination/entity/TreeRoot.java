package com.simple.designpatterns.pattern23.structuretype.combination.entity;

import lombok.Data;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 决策树根
 *
 * @author: WuChengXing
 * @create: 2021-06-26 11:48
 **/
@Data
public class TreeRoot {
    /**
     * 该决策书的id
     */
    private Long treeId;

    /**
     * 该决策树的根节点，也是第一个规则节点的id
     */
    private Long treeRootNodeId;

    /**
     * 树的名称
     */
    private String treeName;

    private TreeRoot treeRoot;
}
