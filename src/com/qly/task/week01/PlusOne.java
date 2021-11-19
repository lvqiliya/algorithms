package com.qly.task.week01;

import java.util.Arrays;

/**
 * 66. 加一
 *
 * 题目分析
 * 场景一：如果末尾没有9，那么直接加一
 * 场景二：如果末尾有9，或者几个9，从后往前找到非9的位置加一，然后将该位置之后的数值替换为0
 * 场景三：如果全是9，那么重新创建数组，长度比原数组大一，然后将首位置为1
 *
 * @author qlylv
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            // 判断数字不为9
            if (digits[i] != 9) {
                // 加一
                ++digits[i];
                // 将该下标的数字之后的数字全部改为0
                for (int j = i + 1; j < n; j++){
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // 每个数字都是9
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] case1 = new int[]{1, 2, 3};
        int[] case2 = new int[]{9, 9};
        int[] case3 = new int[]{1, 9};
        PlusOne obj = new PlusOne();
        obj.plusOne(case1);
        obj.plusOne(case2);
        obj.plusOne(case3);
        System.out.println("case1 + 1 = " + Arrays.toString(case1));
        System.out.println("case2 + 1 = " + Arrays.toString(case2));
        System.out.println("case3 + 1 = " + Arrays.toString(case3));
    }

}
