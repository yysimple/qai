package com.simple.base.uitl;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-07-09 17:16
 **/
public class StringTest {
    public static void main(String[] args) {
        List<Long> platformIds = new ArrayList<>();
        platformIds.add(100L);
        platformIds.add(101L);
        platformIds.add(102L);
        String platformIdsStr = StringUtils.join(platformIds.toArray(), ",");
        System.out.println(platformIdsStr);
    }
}
