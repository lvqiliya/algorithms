package com.qly.leetcode.week06;

/**
 * 42. 接雨水
 *
 * @author qlylv
 */
public class TrappingRainWater {

    public int trap(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return ans;
    }

}
