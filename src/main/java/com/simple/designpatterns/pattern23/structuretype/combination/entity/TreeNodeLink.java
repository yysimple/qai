package com.simple.designpatterns.pattern23.structuretype.combination.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 节点之间的链路指向
 *
 * @author: WuChengXing
 * @create: 2021-06-26 11:45
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TreeNodeLink {
    private Long nodeIdFrom;

    private Long nodeIdTo;

    private Integer ruleLimitType;

    private String ruleLimitValue;
}
