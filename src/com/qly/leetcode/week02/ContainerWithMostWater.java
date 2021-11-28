package com.qly.leetcode.week02;

/**
 * 11. 盛最多水的容器
 * <p>
 * 利用双指针思想。
 * 左值针小于右指针，左值针右移；左值针大于右指针，右指针左移。
 * 每次移动后计算容器大小，（右指针下标 - 左值针下标） * Math.min(左值针的值, 右指针的值)
 * 然后更新最大值，ans = Math.max(ans, calc)
 *
 * @author qlylv
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int ans = 0;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int gap = right - left;
            if (height[left] < height[right]) {
                ans = Math.max(ans, gap * height[left]);
                left++;
            } else {
                ans = Math.max(ans, gap * height[right]);
                right--;
            }
        }
        return ans;
    }

}
