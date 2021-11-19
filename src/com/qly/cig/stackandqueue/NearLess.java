package com.qly.cig.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 单调栈结构 *
 * <p>
 * 给定一个 不含有重复值 的数组 arr，找到每一个 i 位置左边和右边离 i 最近且值比 arr[i] 小的位置。
 * 返回所有位置相应的信息。
 * <p>
 * 举例 arr = {3, 4, 1, 5, 6, 2, 7}
 * 结果
 * {
 * {-1,  2},
 * {0 ,  2},
 * {-1, -1},
 * {2 ,  5},
 * {3 ,  5},
 * {2 , -1},
 * {5 , -1}
 * }
 *
 * @author qlylv
 */
public class NearLess {

    private static final int[] ARR = {3, 4, 1, 5, 6, 2, 7};

    public int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            // 保持从栈顶到栈底单调递减，即栈顶最大
            // 当单调性被破坏的时候，说明栈顶元素需要出栈
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int popIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        // 尚未出栈的元素一定是单调递减排列，栈顶最大，此时每个元素右侧并没有最小值，而左侧的最小值则是栈顶
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        NearLess obj = new NearLess();
        int[][] res = obj.getNearLessNoRepeat(ARR);
        for (int[] item : res) {
            System.out.println(Arrays.toString(item));
        }
    }

}
