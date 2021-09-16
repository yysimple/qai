package com.simple.page.factory;

import com.simple.page.strategy.ImportContext;
import com.simple.page.strategy.ImportStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WuChengXing
 * @date 2021/9/16
 */
@Component
public class ImportFactory<T> {

    @Autowired
    private final Map<String, ImportStrategy> importMap = new HashMap<>(16);

    public ImportContext<T> create(String importType) {
        if ("demo".equals(importType)) {
            return new ImportContext<>(importMap.get(importType));
        }
        return null;
    }
}
