package com.simple.designpatterns.pattern23.behavioral.observer;

import lombok.Data;


/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-07-03 11:46
 **/
@Data
public class OrderResultBo {
    private String msg;

    private Integer code;

    private Long orderId;

    private Long userId;

    public OrderResultBo(String msg, Integer code, Long orderId, Long userId) {
        this.msg = msg;
        this.code = code;
        this.orderId = orderId;
        this.userId = userId;
    }

    public OrderResultBo() {
    }
}
