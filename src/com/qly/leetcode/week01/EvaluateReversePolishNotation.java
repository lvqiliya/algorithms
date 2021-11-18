package com.qly.leetcode.week01;

import java.util.ArrayDeque;

/**
 * 150. 逆波兰表达式求值
 *
 * @author qlylv
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (String str : tokens) {
            if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                int a = nums.pop();
                int b = nums.pop();
                switch (str) {
                    case "+":
                        nums.push(b + a);
                        break;
                    case "-":
                        nums.push(b - a);
                        break;
                    case "*":
                        nums.push(b * a);
                        break;
                    case "/":
                        nums.push(b / a);
                        break;
                    default:
                        System.out.println("Undefined operation symbol");

                }
            } else {
                nums.push(Integer.parseInt(str));
            }
        }
        return nums.pop();
    }

}
