package com.qly.task.week07;

/**
 * 55. 跳跃游戏
 * <p>
 * 解题思路
 * 由于每一个元素的值是可达的最远距离，所以遍历每一个元素时，将它本身的下标值和值，与之前的最大距离进行比较并更新最大距离
 * 当最大距离小于遍历的下标元素时，说明没办法达到后面的元素，直接返回false
 *
 * @author qlylv
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int furthest = 0;
        for (int i = 0; i < n; i++) {
            if (i > furthest) {
                return false;
            }
            furthest = Math.max(furthest, nums[i] + i);
        }
        return true;
    }

}
