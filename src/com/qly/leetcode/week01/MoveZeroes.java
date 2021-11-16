package com.qly.leetcode.week01;

/**
 * 283. 移动零
 *
 * @author qlylv
 */
public class MoveZeroes {

    // 过滤器思想
    public static void removeZeroes(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            // 什么时候要
            // 检查下标是否超过边界
            if (nums[i] != 0) {
                nums[n] = nums[i];
                n++;
            }
        }
        while (n < nums.length) {
            nums[n] = 0;
            n++;
        }
    }

}
