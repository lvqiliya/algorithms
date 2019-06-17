package com.qly;

import java.util.ArrayList;
import java.util.Stack;

public class MonotoneStack {
    public static void main(String[] args) {
        //int[] arr = {3, 4, 1, 5, 6, 2, 7};
        //int[][] res = getNearLessNoRepeat(arr);
        int[] arr = {3, 1, 3, 4, 3, 5, 3, 2, 2};
        int[][] res = getNearLess(arr);
        System.out.println("{");
        for (int i = 0; i < res.length; i++) {
            System.out.print(" {");
            System.out.print(res[i][0] < 0 ? res[i][0] : " " + res[i][0]);
            System.out.print(",");
            System.out.print(res[i][1] < 0 ? res[i][1] : " " + res[i][1]);
            System.out.println(" },");
        }
        System.out.println("}");
    }

    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && arr[i] < arr[stack.peek()]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.empty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.empty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<ArrayList<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && arr[i] < arr[stack.peek().get(0)]) {
                ArrayList<Integer> list = stack.pop();
                int leftLessIndex = stack.empty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer item : list) {
                    res[item][0] = leftLessIndex;
                    res[item][1] = i;
                }
            }

            if (!stack.empty() && arr[i] == arr[stack.peek().get(0)]) {
                stack.peek().add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.empty()) {
            ArrayList<Integer> list = stack.pop();
            int leftLessIndex = stack.empty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer item : list) {
                res[item][0] = leftLessIndex;
                res[item][1] = -1;
            }
        }
        return res;
    }
}
