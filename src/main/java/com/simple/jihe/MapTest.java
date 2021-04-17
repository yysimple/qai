package com.simple.jihe;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: map测试
 *
 * @author: WuChengXing
 * @create: 2021-03-24 11:51
 **/
public class MapTest {
    public static void main(String[] args) {
        /**
         * 对键值没有限制，都可以为空
         * 扩容：newThr = oldThr << 1; // double threshold
         * 这里的扩容有个变化过程，就是节点链表长度过了8会使用红黑树结构
         */
        Map<String, String> map1 = new HashMap<>(16);
        /**
         * 扩容：int newCapacity = (oldCapacity << 1) + 1;
         * 值不能为空：// Make sure the value is not null
         */
        Map<String, String> map2 = new Hashtable<>(16);

        /**
         * 键值两者都不能为空：if (key == null || value == null) throw new NullPointerException();
         */
        Map<String, String> map3 = new ConcurrentHashMap<>(16);

    }
}
