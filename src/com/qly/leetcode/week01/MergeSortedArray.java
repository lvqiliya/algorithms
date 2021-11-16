package com.qly.leetcode.week01;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * @author qlylv
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
        for (int i = 0; i < m + n; i++) {
            System.out.println(nums1[i]);
        }*/
        // 倒序取值，谁大要谁
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            // 考虑边界问题
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) {
                // nums1大
                nums1[k] = nums1[i];
                i--;
            } else {
                // nums2大
                nums1[k] = nums2[j];
                j--;
            }
        }
        System.out.println("nums1 = " + Arrays.toString(nums1) + ", m = " + m + ", nums2 = " + Arrays.toString(nums2) + ", n = " + n);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

}
