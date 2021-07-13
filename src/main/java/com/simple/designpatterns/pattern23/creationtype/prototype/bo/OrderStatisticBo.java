package com.simple.designpatterns.pattern23.creationtype.prototype.bo;

import java.math.BigDecimal;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 前一日的订单统计
 *
 * @author: WuChengXing
 * @create: 2021-07-13 22:03
 **/
public class OrderStatisticBo {
    /**
     * 昨日成功订单数
     */
    private Double successNum;

    /**
     * 昨日失败订单数
     */
    private Double fairNum;

    /**
     * 昨日交易总金额
     */
    private BigDecimal totalAmount;

    public OrderStatisticBo(Double successNum, Double fairNum, BigDecimal totalAmount) {
        this.successNum = successNum;
        this.fairNum = fairNum;
        this.totalAmount = totalAmount;
    }

    public Double getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Double successNum) {
        this.successNum = successNum;
    }

    public Double getFairNum() {
        return fairNum;
    }

    public void setFairNum(Double fairNum) {
        this.fairNum = fairNum;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
