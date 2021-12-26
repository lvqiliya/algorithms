package com.qly.task.week06;

/**
 * 70. 爬楼梯
 * 题目描述
 * 每次可以爬 1 或 2 个台阶，需要 n 阶你才能到达楼顶，问共有多少种爬楼梯方式
 *
 * 解题思路
 * 该题是一个典型的动态规划问题
 * 阶段：线性增长（从 1 到 n）
 * 状态：具有最优子结构（每增加 1 个台阶，最多有多少种爬楼方式）
 * 决策：找到子问题（f(x)=f(x−1)+f(x−2)）
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
        int[] opt = new int[n + 1];
        opt[1] = 1;
        opt[2] = 2;
        for (int i = 3; i <= n; i++) {
            opt[i] = opt[i - 1] + opt[i - 2];
        }
        return opt[n];
    }

}
