package com.qly.leetcode.week01;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @author qlylv
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                // 边界
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch == ')' && stack.peek() != '(') {
                    return false;
                }
                if (ch == ']' && stack.peek() != '[') {
                    return false;
                }
                if (ch == '}' && stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
