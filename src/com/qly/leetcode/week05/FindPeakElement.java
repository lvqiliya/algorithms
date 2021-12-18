package com.qly.leetcode.week05;

/**
 * 162. 寻找峰值
 *
 * @author qlylv
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int lmid = left + (right - left) / 2;
            int rmid = lmid + 1;
            if (nums[lmid] <= nums[rmid]) {
                left = lmid + 1;
            } else {
                right = lmid - 1;
            }
        }
        return right;
    }

}
