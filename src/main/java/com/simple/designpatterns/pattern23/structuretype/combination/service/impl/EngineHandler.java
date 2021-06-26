package com.simple.designpatterns.pattern23.structuretype.combination.service.impl;

import com.simple.designpatterns.pattern23.structuretype.combination.entity.EngineResult;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeNode;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeRich;
import com.simple.designpatterns.pattern23.structuretype.combination.service.BaseEngine;

import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 决策引擎的实现
 *
 * @author: WuChengXing
 * @create: 2021-06-26 13:09
 **/
public class EngineHandler extends BaseEngine {

    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeId, userId, treeRich, decisionMatter);
        return EngineResult.builder().userId(userId).treeId(treeId).treeNodeId(treeNode.getTreeNodeId()).treeNodeValue((String) treeNode.getTreeNodeValue()).build();
    }
}
