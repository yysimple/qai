package com.simple.designpatterns.pattern23.structuretype.combination.service.config;

import com.simple.designpatterns.pattern23.structuretype.combination.service.LogicFilter;
import com.simple.designpatterns.pattern23.structuretype.combination.service.impl.UserAgeFilter;
import com.simple.designpatterns.pattern23.structuretype.combination.service.impl.UserGenderFilter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 决策引擎配置
 *
 * @author: WuChengXing
 * @create: 2021-06-26 12:34
 **/
@Data
public class EngineConfig {
    protected static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new HashMap<>(4);
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }
}
