package com.qly.leetcode.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author qlylv
 */
public class Permutations {

    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> output = new ArrayList<>();
    private List<Boolean> used;

    public List<List<Integer>> permute(int[] nums) {
        used = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            used.add(false);
        }
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int idx) {
        // 递归边界
        if (idx == nums.length) {
            // 代表后续没有任何元素，将临时数组放入ans即可
            ans.add(new ArrayList<>(output));
            return;
        }
        // 递归逻辑
        for (int i = 0; i < nums.length; i++) {
            // 判断该元素是否被使用
            if (!used.get(i)) {
                output.add(nums[i]);
                used.set(i, true);
                recur(nums, idx + 1);
                // 还原现场
                used.set(i, false);
                output.remove(output.size() - 1);
            }
        }
    }

}
