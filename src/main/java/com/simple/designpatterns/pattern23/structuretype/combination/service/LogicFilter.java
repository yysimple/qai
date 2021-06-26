package com.simple.designpatterns.pattern23.structuretype.combination.service;

import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 决策树过滤器
 *
 * @author: WuChengXing
 * @create: 2021-06-26 12:15
 **/
public interface LogicFilter {

    /**
     * 逻辑过滤器
     *
     * @param matterValue   决策值
     * @param treeNodeLinks 决策节点
     * @return
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinks);

    /**
     * 获取决策值方法
     *
     * @param treeId
     * @param userId
     * @param decisionMatter 决策物料
     * @return
     */
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);
}
