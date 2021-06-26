package com.simple.designpatterns.pattern23.structuretype.combination.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 返回值
 *
 * @author: WuChengXing
 * @create: 2021-06-26 11:59
 **/
@Data
@Builder
public class EngineResult {
    private String userId;

    private Long treeId;

    private Long treeNodeId;

    private String treeNodeValue;

}
