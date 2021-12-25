package com.qly.leetcode.week06;

import java.util.Arrays;

/**
 * 455. 分发饼干
 *
 * @author qlylv
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int j = 0;
        for (int child : g) {
            while (j < s.length && s[j] < child) {
                j++;
            }
            if (j < s.length) {
                ans++;
                j++;
            }
        }
        return ans;
    }

}
