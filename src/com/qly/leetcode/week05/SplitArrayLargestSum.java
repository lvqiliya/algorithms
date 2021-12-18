package com.qly.leetcode.week05;

/**
 * 410. 分割数组的最大值
 *
 * @author qlylv
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            // 要想盒子大小能至少装一个元素，那么盒子最小容量就是数组中的最大值
            left = Math.max(left, num);
            // 最差情况下，用一个盒子装完了所有的数
            right += num;
        }
        // 二分判定
        while (left < right) {
            int mid = (left + right) / 2;
            // 校验数组是否能在大小为mid数量为m个盒子中被装下
            if (validate(nums, m, mid)) {
                // 装下了，说明要么盒子数m没有用完，要么用完了但是盒子中的值小于mid
                right = mid;
            } else {
                // 装不下，说明盒子数m用完不够，那么盒子数m不变的情况下，只能扩大盒子容量mid
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 校验当数组拆分个m个子数组时，每一个子数组的和是否能在大小为size的盒子中放得下
     *
     * @param nums 数组
     * @param m    盒子数
     * @param size 盒子大小
     * @return 是否放得下
     */
    private boolean validate(int[] nums, int m, int size) {
        int box = 0;
        int count = 1;
        for (int num : nums) {
            if (box + num <= size) {
                box += num;
            } else {
                // 新开一个盒子
                count++;
                box = num;
            }
        }
        return count <= m;
    }

}
