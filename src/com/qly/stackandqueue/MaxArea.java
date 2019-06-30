package com.qly.stackandqueue;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 * <p>
 * 给出如下矩阵：
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 它的最大的矩形区域有 6 个 1，所以最大为 6。
 *
 * 需要用到单调栈来判断当前被弹出的值向左和向右分别可以扩展到什么位置。
 *
 * @author qly
 */
public class MaxArea {
    public int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }


    public int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.empty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int j = stack.pop();
            int k = stack.empty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);

        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxRecSize(new int[][]{{1, 1, 1, 1}, {1, 1, 0, 1}}));
    }
}
