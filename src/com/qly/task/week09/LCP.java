package com.qly.task.week09;

import java.util.Arrays;

/**
 * 14. 最长公共前缀
 *
 * 解题思路
 * 如果数组存在最长公共前缀，每一个元素两两之间肯定存在
 * 先将数组排序，然后将首尾进行比较提取公共子串
 *
 * @author qlylv
 */
public class LCP {

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        int n = Math.min(start.length(), end.length());
        for (int i = 0; i < n; i++) {
            if (start.charAt(i) != end.charAt(i)) {
                return start.substring(0, i);
            }
        }
        return start.length() < end.length() ? start : end;
    }

}
