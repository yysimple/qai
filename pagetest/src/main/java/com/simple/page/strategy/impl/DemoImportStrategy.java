package com.simple.page.strategy.impl;

import com.alibaba.fastjson.JSON;
import com.simple.page.domain.DemoData;
import com.simple.page.strategy.ImportStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WuChengXing
 * @date 2021/9/15
 */
@Slf4j
@Service("demo")
public class DemoImportStrategy implements ImportStrategy<DemoData> {

    @Override
    public void deal(List<DemoData> data) {
        log.info("读取到的数据：{}", JSON.toJSONString(data));
    }
}
