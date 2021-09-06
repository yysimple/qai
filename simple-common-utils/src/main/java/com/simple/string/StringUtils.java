package com.simple.string;

import com.simple.collect.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: string工具类
 *
 * @author: WuChengXing
 * @create: 2021-08-28 01:11
 **/
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 找到字符串中所有字母异位词
     * eg: 在 s = acdbcdcba  中 找到 p = abc 的异位词，也就是不考虑 abc 的顺序
     *
     * @param s
     * @param p
     * @return
     */
    public static Boolean findAnagrams(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        int[] win = new int[128];
        List<Integer> res = new ArrayList<>(lens);
        if (lenp > lens) {
            return false;
        }
        char[] chs = s.toCharArray(), chp = p.toCharArray();
        for (int i = 0; i < lenp; ++i) {
            ++win[chp[i]];
        }
        int diff = p.length(), right = 0;
        //建立初始窗口
        while (right < lenp) {
            if (win[chs[right]]-- > 0) {
                // 正值变小，diff 减一
                --diff;
            }
            ++right;
        }
        if (diff == 0) {
            res.add(0);
        }
        for (int left = 0; right < lens; ++left, ++right) {
            //入窗, 1-->0
            if (win[chs[right]]-- > 0) {
                --diff;
            }
            //出窗, ++0>0
            if (++win[chs[left]] > 0) {
                ++diff;
            }
            if (diff == 0) {
                res.add(left + 1);
            }
        }
        return !CollectionUtils.isEmpty(res);
    }

    /**
     * 双指针取无序交集：只支持字符串 和 个位数数字
     * String a = "135648220144";
     * String b = "625";
     * 这两种情况，a 中 包含 b
     *
     * @param fatherStr
     * @param subStr
     * @return
     */
    public static String simpleContains(String fatherStr, String subStr) {
        int left = 0;
        int right = fatherStr.length() - 1;
        boolean flag = true;
        while (flag) {
            String lStr = String.valueOf(fatherStr.charAt(left));
            String rStr = String.valueOf(fatherStr.charAt(right));
            boolean lContains = subStr.contains(lStr);
            boolean rContains = subStr.contains(rStr);
            if (lContains) {
                subStr = subStr.replace(lStr, "");
            }
            if (rContains) {
                subStr = subStr.replace(rStr, "");
            }
            left++;
            right--;
            if (left >= right) {
                flag = false;
            }
        }
        return subStr;
    }

    /**
     * 支持数组形式
     *
     * @param fatherStr
     * @param subStr
     * @return
     */
    public static <T> List<T> simpleContains(List<T> fatherStr, List<T> subStr) {
        if (CollectionUtils.isEmpty(fatherStr) || CollectionUtils.isEmpty(subStr)) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = fatherStr.size() - 1;
        boolean flag = true;
        while (flag) {
            T lStr = fatherStr.get(left);
            T rStr = fatherStr.get(right);
            boolean lContains = subStr.contains(lStr);
            boolean rContains = subStr.contains(rStr);
            if (lContains) {
                subStr.remove(lStr);
            }
            if (rContains) {
                subStr.remove(rStr);
            }
            left++;
            right--;
            if (left >= right) {
                flag = false;
            }
        }
        return subStr;
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

        }
        return true;
    }
}
