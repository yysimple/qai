package com.simple.page.strategy;

import java.util.List;

/**
 * @author WuChengXing
 * @date 2021/9/15
 */
public interface ImportStrategy<T> {
    void deal(List<T> data);
}
