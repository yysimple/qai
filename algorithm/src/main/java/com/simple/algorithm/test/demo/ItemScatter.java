package com.simple.algorithm.test.demo;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 功能描述: 阿里面试题
 * 实现一个对商品列表按商家抽取的算法
 * 1. 1、要求
 * (1) 每轮每个商家最多抽取k个商品
 * (2) 每轮的抽取结果要遵循原始商品顺序
 * (3) 抽取后剩下的商品列表保持原始顺序跟随在抽取列表后面
 * (4) itemList.size()<=5000，round<=10，k<=5
 * <p>
 * 2、示例
 * 商品列表及其所属商家
 * item1  SA
 * item2  SA
 * item3  SA
 * item4  SD
 * item5 SB
 * item6  SA
 * item7 SA
 * item8  SA
 * item9 SA
 * item10  SC
 * item11  SA
 * item12  SA
 * item13  SC
 * item14  SA
 * item15  SB
 * item16  SB
 * <p>
 * (1)抽取第1轮，每个商家抽取2个，不足2个抽完为止
 * item1  SA
 * item2  SA
 * item4 SD
 * item5 SB
 * item10  SC
 * item13  SC
 * item15  SB
 * --- 第1轮
 * item3  SA
 * item6  SA
 * item7 SA
 * item8  SA
 * item9 SA
 * item11  SA
 * item12  SA
 * item14  SA
 * item16  SB
 * <p>
 * (2)抽取第2轮，每个商家抽取2个，不足2个抽完为止
 * item1  SA
 * item2  SA
 * item4 SD
 * item5 SB
 * item10  SC
 * item13  SC
 * item15  SB
 * --- 第1轮
 * item3  SA
 * item6  SA
 * item16  SB
 * --- 第2轮
 * item7 SA
 * item8  SA
 * item9 SA
 * item11  SA
 * item12  SA
 * item14  SA
 *
 * @author: WuChengXing
 * @create: 2022-01-23 15:01
 **/
public class ItemScatter {
    /**
     * 对商品列表按商家进行抽取，若无法抽取原样返回
     *
     * @param itemList 原始商品列表
     * @param round    抽取轮数
     * @param k        每轮每个商家抽取商品数
     * @return 抽取之后的商品列表
     */
    public static List<ItemDO> scatter(List<ItemDO> itemList, int round, int k) {
        List<ItemDO> newItemDOs = new LinkedList<>();
        // 这里通过 商家id -> List<ItemDO> 进行缓存；通过groupBy拿到对应的数据
        Map<Long, List<ItemDO>> itemDOKeyValue = itemList.stream().collect(Collectors.toMap(e -> e.getSellerId(), e -> e));
        // 假设
        while (round > 0) {
            // 先从map中找出对应商家的前k个元素
            Set<Map.Entry<Long, List<ItemDO>>> entries = itemDOKeyValue.entrySet();
            Iterator<Map.Entry<Long, List<ItemDO>>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Long, List<ItemDO>> next = iterator.next();
                Long key = next.getKey();
                List<ItemDO> values = next.getValue();
                for (int i = 0; i < k; i++) {
                    ItemDO remove = values.remove(i);
                    newItemDOs.add(remove);
                    removeItem(itemList, key, remove.getItemId());
                }
            }
            Set<Long> longs = itemDOKeyValue.keySet();
            round--;
        }
        // TODO
        return itemList;
    }

    // 根据 一些操作 可移除指定的元素
    public static void removeItem(List<ItemDO> itemList, long itemId, long sellerId){
        //
        return;
    }

    @Data
    class ItemDO {
        private long itemId;
        private long sellerId;
    }

    public static List<ItemDO> init() {
        return null;
    }
}
