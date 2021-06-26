package com.simple.designpatterns.pattern23.structuretype.combination.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 决策树节点
 *
 * @author: WuChengXing
 * @create: 2021-06-26 11:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TreeNode {
    private Long treeId;

    private Long treeNodeId;

    private Integer treeNodeType;

    private Object treeNodeValue;

    private String ruleKey;

    private String ruleDesc;

    private List<TreeNodeLink> treeNodeLinks;
}
