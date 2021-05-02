package com.simple.algorithm.array;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: 最长公共前缀
 *
 * @author: WuChengXing
 * @create: 2021-05-02 09:50
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String prefix = getPrefix02(strs);
        System.out.println(prefix);
    }

    /**
     * 根据字符串的两个函数去找到最长的公共前缀
     *
     * @param strings
     * @return
     */
    public static String getPrefix01(String[] strings) {
        int length = strings.length;
        if (length < 1) {
            return "";
        }
        // 拿数组第一个字符串
        String prefix = strings[0];
        for (String string : strings) {
            // 使用字符串的函数去判断是否是其前缀
            while (!string.startsWith(prefix)) {
                // 不是的情况下，将字符串截取一位
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static String getPrefix02(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        //用于存储字符串遍历的最小长度
        int len = strings.length;
        //外层for循环遍历每个字符索引，strings[0].length长度是不断变化的
        for (int i = 0; i < strings[0].length(); i++) {
            //取出单个字符，用于字符串之间的匹配
            char c = strings[0].charAt(i);
            //内层for循环遍历每个字符串
            for (int j = 0; j < len; j++) {
                /*当需要匹配的字符索引超过字符串的长度，
                    或者字符串某个位置的字符不匹配时，削减最长前缀
                    同时要刷新字符串遍历的最小长度len（因为超过len的部分肯定不匹配了）*/
                if (i == strings[j].length() || strings[j].charAt(i) != c) {
                    strings[0] = strings[0].substring(0, i);
                    len = j;
                }
            }
        }
        //返回最长公共前缀
        return strings[0];
    }
}
