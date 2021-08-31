package com.simple.collect;

import java.util.List;

/**
 * 功能描述: 集合相关工具类
 *
 * @author: WuChengXing
 * @create: 2021-08-29 22:58
 **/
public class CollectionUtils {

    public static <T> boolean isEmpty(List<T> res) {
        if (res == null || res.size() < 1) {
            return false;
        }
        return true;
    }
}
