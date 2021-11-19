package com.qly.leetcode.week01;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 84. 柱状图中最大的矩形
 *
 * @author qlylv
 */
public class LargestRectangle {

    public int largestRectangleArea(int[] heights) {
        Deque<Rect> stack = new ArrayDeque<>();
        int ans = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int height;
            if (i != n) {
                height = heights[i];
            } else {
                height = 0;
            }
            int accumulatedWidth = 0;
            while (!stack.isEmpty() && stack.peek().getHeight() >= height) {
                Rect rect = stack.pop();
                accumulatedWidth += rect.getWidth();
                ans = Math.max(ans, rect.getHeight() * accumulatedWidth);
            }
            stack.push(new Rect(accumulatedWidth + 1, height));
        }
        return ans;
    }

    static class Rect {
        private int width;
        private int height;

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public static void main(String[] args) {
        LargestRectangle lr = new LargestRectangle();
        int[] arr = {2};
        System.out.println(lr.largestRectangleArea(arr));
    }

}
