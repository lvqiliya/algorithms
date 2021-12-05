package com.qly.leetcode.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author qlylv
 */
public class Subsets {

    private List<Integer> temp = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    /**
     * 递归去判断第i个数是否选择
     * @param i index
     */
    private void dfs(int i, int[] nums) {
        // 确定边界
        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 递归逻辑，nums[i]选或者不选
        dfs(i + 1, nums);
        temp.add(nums[i]);
        dfs(i + 1, nums);
        // 还原现场
        temp.remove(temp.size() - 1);
    }

}
