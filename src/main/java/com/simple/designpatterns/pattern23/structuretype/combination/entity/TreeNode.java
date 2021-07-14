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
    /**
     * 树id
     */
    private Long treeId;

    /**
     * 树节点id
     */
    private Long treeNodeId;

    /**
     * 节点类型：1=叶子节点，2=果实节点
     */
    private Integer treeNodeType;

    private Object treeNodeValue;

    /**
     * 这里是节点规则：对应是按什么去过滤数据，比如（性别（gender）、年龄（age））
     */
    private String ruleKey;

    private String ruleDesc;

    /**
     * 这里是维持 两个节点之前的关系的“树枝”，可能有多种情况
     */
    private List<TreeNodeLink> treeNodeLinks;
}
