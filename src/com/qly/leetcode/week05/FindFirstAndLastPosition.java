package com.qly.leetcode.week05;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author qlylv
 */
public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] ans = new int[2];
        // 执行了两次时间复杂度为 O(log n) 的二分算法
        ans[0] = successor(nums, target);
        ans[1] = predecessor(nums, target);
        return ans;
    }

    /**
     * 寻找 target 的后继位置
     * @param nums 有序数组
     * @param target 目标值
     * @return 下标值
     */
    private int successor(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    /**
     * 寻找 target 的前驱位置
     * @param nums 有序数组
     * @param target 目标值
     * @return 下标值
     */
    private int predecessor(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

}
