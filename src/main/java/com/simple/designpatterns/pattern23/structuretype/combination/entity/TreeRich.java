package com.simple.designpatterns.pattern23.structuretype.combination.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-26 11:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeRich {

    private TreeRoot treeRoot;

    private Map<Long, TreeNode> treeNodeMap;
}
