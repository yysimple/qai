package com.simple.page.listener;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WuChengXing
 * @date 2021/9/15
 */
@Service
public class DemoDAO<T> {
    public void save(List<T> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
    }

}
