package com.qly.task.week07;

/**
 * 279. 完全平方数
 * <p>
 * 解题思路
 * 该题是典型的动态规划问题
 * 阶段：线性增长（从 1 到 n）
 * 状态：具有最优子结构（每增加 1，最少多少种方式满足题意）
 * 决策：找到子问题（最小值只能f[i]和f[i-j*j]中取最小的）
 *
 * @author qlylv
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = i;
            for (int j = 0; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }

}
