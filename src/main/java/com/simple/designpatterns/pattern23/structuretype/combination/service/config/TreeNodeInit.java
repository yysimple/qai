package com.simple.designpatterns.pattern23.structuretype.combination.service.config;

import com.simple.designpatterns.pattern23.structuretype.combination.Constant;
import com.simple.designpatterns.pattern23.structuretype.combination.ExpressionEnum;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeNode;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeNodeLink;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeRich;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeRoot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-26 13:14
 **/
public class TreeNodeInit {
    public TreeRich init() {
        TreeNode treeNode_01 = TreeNode.builder()
                .treeId(10001L)
                .treeNodeId(1L)
                .treeNodeType(Constant.NODE_TYPE_LEAF)
                .treeNodeValue(null)
                .ruleKey("userGender")
                .ruleDesc("用户性别[男/女]")
                .build();

        // 1 --> 11
        TreeNodeLink treeNodeLink_11 = TreeNodeLink.builder()
                .nodeIdFrom(1L)
                .nodeIdTo(11L)
                .ruleLimitType(ExpressionEnum.EQUAL.getIndex())
                .ruleLimitValue("man")
                .build();

        // 1 --> 12
        TreeNodeLink treeNodeLink_12 = TreeNodeLink.builder()
                .nodeIdFrom(1L)
                .nodeIdTo(12L)
                .ruleLimitType(ExpressionEnum.EQUAL.getIndex())
                .ruleLimitValue("woman")
                .build();

        List<TreeNodeLink> treeNodeLinks_1 = new ArrayList<>();
        treeNodeLinks_1.add(treeNodeLink_11);
        treeNodeLinks_1.add(treeNodeLink_12);
        treeNode_01.setTreeNodeLinks(treeNodeLinks_1);

        // ------------------------------------------
        TreeNode treeNode_11 = TreeNode.builder()
                .treeId(10001L)
                .treeNodeId(11L)
                .treeNodeType(Constant.NODE_TYPE_LEAF)
                .treeNodeValue(null)
                .ruleKey("userAge")
                .ruleDesc("用户年龄")
                .build();

        // 11 --> 111
        TreeNodeLink treeNodeLink_111 = TreeNodeLink.builder()
                .nodeIdFrom(11L)
                .nodeIdTo(111L)
                .ruleLimitType(ExpressionEnum.LESS.getIndex())
                .ruleLimitValue("25")
                .build();

        // 11 --> 112
        TreeNodeLink treeNodeLink_112 = TreeNodeLink.builder()
                .nodeIdFrom(11L)
                .nodeIdTo(112L)
                .ruleLimitType(ExpressionEnum.GRANT_EQUAL.getIndex())
                .ruleLimitValue("25")
                .build();

        List<TreeNodeLink> treeNodeLinks_11 = new ArrayList<>();
        treeNodeLinks_11.add(treeNodeLink_111);
        treeNodeLinks_11.add(treeNodeLink_112);
        treeNode_11.setTreeNodeLinks(treeNodeLinks_11);

        // ------------------------------------------
        TreeNode treeNode_12 = TreeNode.builder()
                .treeId(10001L)
                .treeNodeId(12L)
                .treeNodeType(Constant.NODE_TYPE_LEAF)
                .treeNodeValue(null)
                .ruleKey("userAge")
                .ruleDesc("用户年龄")
                .build();

        // 12 --> 121
        TreeNodeLink treeNodeLink_121 = TreeNodeLink.builder()
                .nodeIdFrom(12L)
                .nodeIdTo(121L)
                .ruleLimitType(ExpressionEnum.LESS.getIndex())
                .ruleLimitValue("25")
                .build();

        // 11 --> 122
        TreeNodeLink treeNodeLink_122 = TreeNodeLink.builder()
                .nodeIdFrom(12L)
                .nodeIdTo(122L)
                .ruleLimitType(ExpressionEnum.GRANT_EQUAL.getIndex())
                .ruleLimitValue("25")
                .build();

        List<TreeNodeLink> treeNodeLinks_12 = new ArrayList<>();
        treeNodeLinks_12.add(treeNodeLink_121);
        treeNodeLinks_12.add(treeNodeLink_122);
        treeNode_12.setTreeNodeLinks(treeNodeLinks_12);

        /**
         * 结果
         */

        TreeNode treeNode_111 = TreeNode.builder()
                .treeId(10001L)
                .treeNodeId(111L)
                .treeNodeType(Constant.NODE_TYPE_FRUIT)
                .treeNodeValue("果实A ===> 男，<25")
                .build();
        TreeNode treeNode_112 = TreeNode.builder()
                .treeId(10001L)
                .treeNodeId(112L)
                .treeNodeType(Constant.NODE_TYPE_FRUIT)
                .treeNodeValue("果实B ===> 男，>=25")
                .build();
        TreeNode treeNode_121 = TreeNode.builder()
                .treeId(10001L)
                .treeNodeId(121L)
                .treeNodeType(Constant.NODE_TYPE_FRUIT)
                .treeNodeValue("果实C ===> 女，<25")
                .build();
        TreeNode treeNode_122 = TreeNode.builder()
                .treeId(10001L)
                .treeNodeId(122L)
                .treeNodeType(Constant.NODE_TYPE_FRUIT)
                .treeNodeValue("果实D ===> 女，>=25")
                .build();

        //--------- 树根 ----------------
        TreeRoot treeRoot = new TreeRoot();
        treeRoot.setTreeId(10001L);
        // 这里是记录这整个决策树的第一个规则节点是什么
        treeRoot.setTreeRootNodeId(1L);
        treeRoot.setTreeName("决策树");
        Map<Long, TreeNode> treeNodeMap = new HashMap<>(16);
        treeNodeMap.put(1L, treeNode_01);
        treeNodeMap.put(11L, treeNode_11);
        treeNodeMap.put(12L, treeNode_12);
        treeNodeMap.put(111L, treeNode_111);
        treeNodeMap.put(112L, treeNode_112);
        treeNodeMap.put(121L, treeNode_121);
        treeNodeMap.put(122L, treeNode_122);
        TreeRich treeRich = new TreeRich();
        treeRich.setTreeRoot(treeRoot);
        treeRich.setTreeNodeMap(treeNodeMap);
        return treeRich;
    }
}
