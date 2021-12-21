package com.qly.leetcode.week06;

/**
 * 70. 爬楼梯
 * <p>
 * 爬一级楼梯，只能爬1个台阶，只有1种情况
 * 爬二级楼梯，可以爬1或2个台阶，分为爬两次1、一次2，共计2种情况
 * 爬三级楼梯，可以爬1或2个台阶，分为爬三次1、一次1一次2，一次2一次1，共计3种情况
 * 爬四级楼梯，可以爬1或2个台阶，分为爬四次1、两次2、一次1一次1一次2、一次1一次2一次1、一次2一次1一次1，共计5种情况
 * ......
 * 爬n级楼梯，可以爬1或2个台阶，分为爬n-1级楼梯+n-2级楼梯的和
 *
 * @author qlylv
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
