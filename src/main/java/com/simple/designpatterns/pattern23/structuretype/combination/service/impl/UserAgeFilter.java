package com.simple.designpatterns.pattern23.structuretype.combination.service.impl;

import com.simple.designpatterns.pattern23.structuretype.combination.service.BaseLogicFilter;

import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 用户年龄逻辑判断节点
 *
 * @author: WuChengXing
 * @create: 2021-06-26 12:28
 **/
public class UserAgeFilter extends BaseLogicFilter {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
