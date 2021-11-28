package com.qly.leetcode.week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author qlylv
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> sums = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> sum : sums) {
                sum.add(nums[i]);
                ans.add(sum);
            }
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> sums = new ArrayList<>();
        int j = nums.length - 1;
        for (int i = start; i < nums.length; i++) {
            while (i < j && nums[i] + nums[j] > target) {
                j--;
            }
            List<Integer> list = null;
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (i < j && nums[i] + nums[j] == target) {
                list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
            }
            if (list != null) {
                sums.add(list);
            }
        }
        return sums;
    }

}
