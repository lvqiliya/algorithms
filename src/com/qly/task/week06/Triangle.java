package com.qly.task.week06;

import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * 解题思路
 * 该题是一个典型的动态规划问题
 * 阶段：线性增长（从第 1 行到第 n 行，每一行都是一个数组，数组长度等于 n）
 * 状态：具有最优子结构（每增加一行，最小路径就是上一行最小值 + 本行最小值）
 * 决策：找到子问题（最小值只能triangle[i][j] + triangle[i-1][j或j-1]，要最小的）
 *
 * 边界问题
 * 如果三角形最左边是最小路径，独立处理为triangle[i][0] + triangle[i-1][0]
 * 如果三角形最右边是最小路径，独立处理为triangle[i][i] + triangle[i-1][i-1]
 *
 * @author qlylv
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] opt = new int[n][n];
        // 三角形顶部元素就是最小路径
        opt[0][0] = triangle.get(0).get(0);
        // 从第二行开始遍历
        for (int i = 1; i < n; i++) {
            // 最左边
            opt[i][0] = opt[i - 1][0] + triangle.get(i).get(0);
            // 中间部分
            for (int j = 1; j < i; j++) {
                opt[i][j] = Math.min(opt[i - 1][j - 1], opt[i - 1][j]) + triangle.get(i).get(j);
            }
            // 最右边
            opt[i][i] = opt[i - 1][i - 1] + triangle.get(i).get(i);
        }
        // 以上操作已经将所有可能的最小路径都放入了opt数组中的最后一行
        int ans = opt[n - 1][0];
        for (int i = 1; i < n; i++) {
            // 遍历最后一行并取最小值为答案
            ans = Math.min(ans, opt[n - 1][i]);
        }
        return ans;
    }

}
