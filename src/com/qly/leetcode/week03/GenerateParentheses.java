package com.qly.leetcode.week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 22. 括号生成
 *
 * @author qlylv
 */
public class GenerateParentheses {

    private final Map<Integer, List<String>> store = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (store.containsKey(n)) {
            return store.get(n);
        }
        if (n == 0) {
            ans.add("");
            return ans;
        }
        for (int k = 1; k <= n; k++) {
            List<String> front = generateParenthesis(k - 1);
            List<String> behind = generateParenthesis(n - k);
            for (String f : front) {
                for (String b : behind) {
                    ans.add("(" + f + ")" + b);
                }
            }
        }
        store.put(n, ans);
        return ans;
    }

}
