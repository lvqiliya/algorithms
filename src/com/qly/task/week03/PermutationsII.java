package com.qly.task.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums，按任意顺序返回所有不重复的全排列。
 * <p>
 * 解答思路：本题全排列的进阶
 *
 * @author qlylv
 */
public class PermutationsII {

    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> output = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int idx) {
        // 递归边界
        if (idx == nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }
        // 递归逻辑
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝逻辑 当前元素和前驱元素相等&&前一个元素没有被使用时，跳过该重复元素
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            output.add(nums[i]);
            used[i] = true;
            recur(nums, idx + 1);
            // 还原现场
            used[i] = false;
            output.remove(idx);
        }
    }

}
