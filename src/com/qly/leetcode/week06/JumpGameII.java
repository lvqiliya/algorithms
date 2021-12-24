package com.qly.leetcode.week06;

/**
 * 45. 跳跃游戏 II
 *
 * @author qlylv
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int steps = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // i + nums[i]表示从当前位置+最大长度=可达的最远位置
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }

}
