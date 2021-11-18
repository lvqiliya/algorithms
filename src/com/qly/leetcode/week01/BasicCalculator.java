package com.qly.leetcode.week01;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 224. 基本计算器
 *
 * @author qlylv
 */
public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        calculator.calculate("(1+(4+5+2)-3)+(6+8)");
    }

    public int calculate(String s) {
        StringBuilder number = new StringBuilder();
        ArrayList<String> exp = new ArrayList<>();
        ArrayDeque<Character> ops = new ArrayDeque<>();
        s = s.replaceAll(" ", "") + " ";
        boolean needsZero = true;
        for (char ch : s.toCharArray()) {
            // 处理整数，需要考虑多位数
            if (Character.isDigit(ch)) {
                number.append(ch);
                needsZero = false;
                continue;
            } else {
                if (!number.toString().isEmpty()) {
                    exp.add(number.toString());
                    number = new StringBuilder();
                }
            }
            // 处理空格
            if (ch == ' ') {
                continue;
            }
            // 处理括号
            if (ch == '(') {
                ops.push(ch);
                needsZero = true;
                continue;
            }
            if (ch == ')') {
                while (ops.peek() != '(') {
                    exp.add(String.valueOf(ops.pop()));
                }
                ops.pop();
                needsZero = false;
                continue;
            }
            // 补0
            if (needsZero && (ch == '+' || ch == '-')) {
                exp.add("0");
            }
            // 处理符号
            int currRank = getRank(ch);
            while (!ops.isEmpty() && currRank <= getRank(ops.peek())) {
                exp.add(String.valueOf(ops.pop()));
            }
            ops.push(ch);
            needsZero = true;
        }
        while (!ops.isEmpty()) {
            exp.add(String.valueOf(ops.pop()));
        }
        System.out.println(exp.toString());
        return evalRPN(exp.toArray(new String[0]));
    }

    private int getRank(char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 0;
        }
    }

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
        System.out.println(nums.peek());
        return nums.pop();
    }

}
