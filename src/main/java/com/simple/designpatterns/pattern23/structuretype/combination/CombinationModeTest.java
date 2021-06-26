package com.simple.designpatterns.pattern23.structuretype.combination;

import com.alibaba.fastjson.JSON;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.EngineResult;
import com.simple.designpatterns.pattern23.structuretype.combination.entity.TreeRich;
import com.simple.designpatterns.pattern23.structuretype.combination.service.IEngine;
import com.simple.designpatterns.pattern23.structuretype.combination.service.config.TreeNodeInit;
import com.simple.designpatterns.pattern23.structuretype.combination.service.impl.EngineHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 组合模式
 *
 * @author: WuChengXing
 * @create: 2021-06-26 11:41
 **/
@Slf4j
public class CombinationModeTest {
    public static void main(String[] args) {
        TreeNodeInit treeNodeInit = new TreeNodeInit();
        TreeRich init = treeNodeInit.init();

        IEngine engine = new EngineHandler();
        Map<String, String> decisionMap = new HashMap<>(2);
        decisionMap.put("gender", "man");
        decisionMap.put("age", "29");
        EngineResult result = engine.process(10001L, "sasassa", init, decisionMap);
        log.info("result ==> {}", JSON.toJSON(result));
    }
}
