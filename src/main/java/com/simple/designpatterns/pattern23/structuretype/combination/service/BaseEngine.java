package com.simple.designpatterns.pattern23.structuretype.combination.service;

import com.simple.designpatterns.pattern23.structuretype.combination.entity.EngineResult;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeNode;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeRich;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeRoot;
import com.simple.designpatterns.pattern23.structuretype.combination.service.config.EngineConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 基础执行引擎
 *
 * @author: WuChengXing
 * @create: 2021-06-26 12:51
 **/
@Slf4j
public abstract class BaseEngine extends EngineConfig implements IEngine {

    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

    public TreeNode engineDecisionMaker(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        // 规则树根Id
        Long treeRootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNode = treeNodeMap.get(treeRootNodeId);
        // treeNodeType: 1=叶子节点，2=果实
        while (treeNode.getTreeNodeType() == 1) {
            // 拿到对应的规则节点对应的key
            String ruleKey = treeNode.getRuleKey();
            // 拿到过滤规则
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            // 拿到map对应的需要进行比较的值，即客户端传过来的值
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            // 这里去通过“树枝”，过了校验就获取下一个规则
            Long nextNodeId = logicFilter.filter(matterValue, treeNode.getTreeNodeLinks());
            treeNode = treeNodeMap.get(nextNodeId);
            log.info("决策树引擎：===> 返回值：ruleKey: {}, matterValue: {}, nextNodeId: {}", ruleKey, matterValue, nextNodeId);
        }
        return treeNode;
    }

}
