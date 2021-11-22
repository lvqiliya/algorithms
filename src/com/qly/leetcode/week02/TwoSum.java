package com.qly.leetcode.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author qlylv
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                ans[0] = map.get(diff);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
