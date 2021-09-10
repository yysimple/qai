package com.simple.util;

/**
 * @author WuChengXing
 * @date 2021/9/10
 */
public class NumberUtils {

    /**
     * 检查id 有效性
     */
    public static boolean isValidId(Integer id) {
        return (id != null && id > 0);
    }
}
