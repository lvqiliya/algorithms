package com.qly.leetcode.week01;

/**
 * 26. 删除有序数组中的重复项
 *
 * @author qlylv
 */
public class RemoveDuplicates {

    // 过滤器思想
    public static int removeDuplicates(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            // 什么时候要
            // 检查下标是否超过边界
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }

}
