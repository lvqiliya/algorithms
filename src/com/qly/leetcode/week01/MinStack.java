package com.qly.leetcode.week01;

import java.util.Stack;

/**
 * 155. 最小栈
 *
 * @author qlylv
 */
public class MinStack {

    private final Stack<Integer> nums;
    private final Stack<Integer> min;

    public MinStack() {
        nums = new Stack<>();
        min = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        min.push(Math.min(min.peek(), val));
        nums.push(val);
    }

    public void pop() {
        min.pop();
        nums.pop();
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
