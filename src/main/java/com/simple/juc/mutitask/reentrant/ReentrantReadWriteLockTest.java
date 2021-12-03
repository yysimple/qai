package com.simple.juc.mutitask.reentrant;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 功能描述: 基于 rrwl的缓存设计
 *
 * @author: WuChengXing
 * @create: 2021-12-03 17:44
 **/
public class ReentrantReadWriteLockTest {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    /**
     * 获取一个 key 对应的 value
     *
     * @param key
     * @return
     */
    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    /**
     * 设置 key 对应的 value，并返回旧的 value
     *
     * @param key
     * @param value
     * @return
     */
    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    /**
     * 清空所有的内容
     */
    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

}
