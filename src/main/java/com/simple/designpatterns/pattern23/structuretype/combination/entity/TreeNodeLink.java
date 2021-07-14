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
    /**
     * 上一个节点的id
     */
    private Long nodeIdFrom;

    /**
     * 下一个节点id
     */
    private Long nodeIdTo;

    /**
     * 这个是过滤的类型；这个是枚举，查看 == ExpressionEnum
     */
    private Integer ruleLimitType;

    /**
     * 这个是具体的值：比如 man、women、19、52等之类的限定值
     */
    private String ruleLimitValue;
}
