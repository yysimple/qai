package com.simple.page.strategy;

import java.util.List;

/**
 * @author WuChengXing
 * @date 2021/9/16
 */
public class ImportContext<T> {
    private final ImportStrategy<T> strategy;

    public ImportContext(ImportStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void deal(List<T> data) {
        strategy.deal(data);
    }
}
