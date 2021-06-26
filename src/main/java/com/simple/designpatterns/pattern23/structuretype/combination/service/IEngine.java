package com.simple.designpatterns.pattern23.structuretype.combination.service;

import com.simple.designpatterns.pattern23.structuretype.combination.entity.EngineResult;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeRich;

import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 决策引擎
 *
 * @author: WuChengXing
 * @create: 2021-06-26 12:31
 **/
public interface IEngine {

    /**
     * 处理决策树，返回特定值
     * @param treeId
     * @param userId
     * @param treeRich
     * @param decisionMatter
     * @return
     */
    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);
}
