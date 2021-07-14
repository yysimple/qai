package com.simple.designpatterns.pattern23.structuretype.combination.service;

import com.simple.designpatterns.pattern23.structuretype.combination.Constant;
import com.simple.designpatterns.pattern23.structuretype.combination.ExpressionEnum;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeNodeLink;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 基础决策过滤器,提供一些基础服务
 *
 * @author: WuChengXing
 * @create: 2021-06-26 12:19
 **/
public abstract class BaseLogicFilter implements LogicFilter {

    /**
     * 过滤到下一个节点（即第一个规则通过了，就指向下一个规则）
     * @param matterValue   决策值
     * @param treeNodeLinks 决策节点
     * @return
     */
    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinks) {
        for (TreeNodeLink treeNodeLink : treeNodeLinks) {
            // 匹配上了这些规则，继续往下走（这里是“树枝”，里面有界限值和指向）
            if (decisionLogic(matterValue, treeNodeLink)) {
                // “树枝”上面的校验通过了，则返回下一个规则节点的id
                return treeNodeLink.getNodeIdTo();
            }
        }
        return 0L;
    }

    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

    /**
     * 校验传入的
     * @param matterValue
     * @param treeNodeLink
     * @return
     */
    public Boolean decisionLogic(String matterValue, TreeNodeLink treeNodeLink) {
        switch (Objects.requireNonNull(ExpressionEnum.getByIndex(treeNodeLink.getRuleLimitType()))) {
            case EQUAL:
                return matterValue.equals(treeNodeLink.getRuleLimitValue());
            case GRANT:
                return Double.parseDouble(matterValue) > Double.parseDouble(treeNodeLink.getRuleLimitValue());
            case LESS:
                return Double.parseDouble(matterValue) < Double.parseDouble(treeNodeLink.getRuleLimitValue());
            case LESS_EQUAL:
                return Double.parseDouble(matterValue) <= Double.parseDouble(treeNodeLink.getRuleLimitValue());
            case GRANT_EQUAL:
                return Double.parseDouble(matterValue) >= Double.parseDouble(treeNodeLink.getRuleLimitValue());
            default:
                return false;
        }
    }
}
