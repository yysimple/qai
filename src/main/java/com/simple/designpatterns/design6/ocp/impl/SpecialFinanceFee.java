package com.simple.designpatterns.design6.ocp.impl;

/**
 * @author chengxing.wu
 * @date 2021/6/4 17:13
 */
public class SpecialFinanceFee extends FeeServiceImpl {

    /**
     * 特殊费率：这里不去修改之前的类，是符合开闭原则的
     */
    public static final Double SPECIAL_FEE = 0.005D;

    /**
     * 但是这里的话，覆盖了父类方法，虽然不会影响父类方法调用，也即想使用父类的还是可以继续使用,但是
     * == 但是我这个子类就失去了父类的功能，我想走正常的费率也只能去使用 new 父类了，这样复用性不强
     * @param level
     * @return
     */
    @Override
    public Double getFinancialFee(String level) {
        if ("1".equals(level)) {
            return SPECIAL_FEE * 0.1;
        } else if ("2".equals(level)) {
            return SPECIAL_FEE * 0.2;
        } else {
            return SPECIAL_FEE;
        }
    }

    /**
     *
     * @param level
     * @return
     */
    public Double getSpecialFinancialFee(String level) {
        if ("1".equals(level)) {
            return SPECIAL_FEE * 0.1;
        } else if ("2".equals(level)) {
            return SPECIAL_FEE * 0.2;
        } else {
            return SPECIAL_FEE;
        }
    }
}
