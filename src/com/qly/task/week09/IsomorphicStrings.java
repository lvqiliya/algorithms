package com.qly.task.week09;

/**
 * 205. 同构字符串
 *
 * @author qlylv
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // 如果每个字符第一次出现的位置不同，那么就不是同构字符串
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
