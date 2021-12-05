package com.qly.leetcode.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * @author qlylv
 */
public class Combinations {

    private List<Integer> temp = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    private void dfs(int i, int n, int k) {
        // 剪枝
        if (temp.size() + n - i + 1 < k) {
            return;
        }
        // 记录答案
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 递归逻辑
        temp.add(i);
        dfs(i + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(i + 1, n, k);
    }

}
