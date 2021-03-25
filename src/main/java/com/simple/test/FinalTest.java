package com.simple.test;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-22 11:13
 **/
public class FinalTest {
    private Integer var;

    public void getNum(Integer var) {
        class FinalTest3 {
            public Integer getAge() {
                return var;
            }
        }
    }

}
