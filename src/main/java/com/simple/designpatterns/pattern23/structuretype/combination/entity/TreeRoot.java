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
    private Long treeId;

    private Long treeRootNodeId;

    private String treeName;

    private TreeRoot treeRoot;
}
