package com.simple.designpatterns.pattern23.creationtype.prototype.impl;

import com.simple.designpatterns.pattern23.creationtype.prototype.Statistic;
import com.simple.designpatterns.pattern23.creationtype.prototype.bo.OrderStatisticBo;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 统计实现类
 *
 * @author: WuChengXing
 * @create: 2021-07-13 22:08
 **/
public class StatisticImpl implements Statistic {

    static Map<String, OrderStatisticBo> orderStatisticBoMap = new HashMap<>(8);


    @Override
    public Map<String, OrderStatisticBo> totalOrder() {
        if (CollectionUtils.isEmpty(orderStatisticBoMap)) {
            System.out.println("==== 我走的是查询数据库，我需要构建复杂对象，进行初始化 =======");
            orderStatisticBoMap = getOrderStatisticBoForThreeDay();
            return orderStatisticBoMap;
        }
        System.out.println("==== 我走的是缓存，我用了享元模式思想，我不用查数据库去构建复杂对象 =========");
        return orderStatisticBoMap;
    }

    /**
     * 模拟从数据库里取出最近三天的订单统计
     *
     * @return
     */
    private Map<String, OrderStatisticBo> getOrderStatisticBoForThreeDay() {
        Map<String, OrderStatisticBo> map = new HashMap<>(4);
        map.put("2021/07/10", new OrderStatisticBo(10D, 2D, new BigDecimal(5220)));
        map.put("2021/07/11", new OrderStatisticBo(11D, 3D, new BigDecimal(6220)));
        map.put("2021/07/12", new OrderStatisticBo(12D, 4D, new BigDecimal(7220)));
        return map;
    }
}
