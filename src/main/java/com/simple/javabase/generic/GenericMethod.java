package com.simple.javabase.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WuChengXing
 * @date 2021/7/21
 */
public class GenericMethod<K, V> {
    private K key;
    private V value;

    Map<K, V> map = new HashMap<>();

    public K getKey() {
        return key;
    }

    public <T> T dealValue(K key) {
        V v = map.get(key);
        return (T) (v);
    }
}
