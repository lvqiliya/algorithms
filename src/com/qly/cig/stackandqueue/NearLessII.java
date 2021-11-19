package com.qly.cig.stackandqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 单调栈结构 *
 * <p>
 * 给定一个 含有重复值 的数组 arr，找到每一个 i 位置左边和右边离 i 最近且值比 arr[i] 小的位置。
 * 返回所有位置相应的信息。
 * <p>
 * 举例 arr = {3, 1, 3, 4, 3, 5, 3, 2, 2}
 *
 * @author qlylv
 */
public class NearLessII {

    private static final int[] ARR = {3, 1, 3, 4, 3, 5, 3, 2, 2};

    public int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Deque<List<Integer>> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            // 保持从栈顶到栈底单调递减，即栈顶最大
            // 当单调性被破坏的时候，说明栈顶元素需要出栈
            while (!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]) {
                List<Integer> popIs = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (int popI : popIs) {
                    res[popI][0] = leftIndex;
                    res[popI][1] = i;
                }
            }
            // 插入元素利用数组来代表栈帧
            // 当数组不为空且下标数值等于栈帧所代表数值的时候，将下标作为元素加入到该栈帧之中
            // 否则新建数组作为栈帧
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        // 尚未出栈的元素一定是单调递减排列，栈顶最大，此时每个元素右侧并没有最小值，而左侧的最小值则是栈顶
        while (!stack.isEmpty()){
            List<Integer> popIs = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (int popI : popIs) {
                res[popI][0] = leftIndex;
                res[popI][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NearLessII obj = new NearLessII();
        int[][] res = obj.getNearLess(ARR);
        for (int[] item : res) {
            System.out.println(Arrays.toString(item));
        }
    }

}
