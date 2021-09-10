package com.simple.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author WuChengXing
 * @date 2021/8/17
 */
public class FunctionUtil {
    public static <T> void whenNonNullDo(Consumer<T> c, T val) {
        if (val == null) {
            return;
        }
        if (val instanceof Number) {
            Optional.of(val).filter(i -> NumberUtils.isValidId(((Number) i).intValue())).ifPresent(c);
            return;
        } else if (val instanceof String) {
            Optional.of(val).filter(i -> StrUtil.isNotEmpty((String) i)).ifPresent(c);
        }
        Optional.of(val).filter(i -> ObjectUtil.isNotEmpty(i)).ifPresent(c);
    }

    /**
     * 自定义函数去重
     *
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
