package com.simple.designpatterns.pattern23.behavioral.command.impl;

import com.simple.designpatterns.pattern23.behavioral.command.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-28 22:46
 **/
@Slf4j
public class GuangDongCook implements ICook {

    @Override
    public void cooking() {
        log.info("广东厨师，做粤菜，甜的");
    }
}
