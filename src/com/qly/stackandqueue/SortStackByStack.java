package com.qly.stackandqueue;

import java.util.Stack;

public class SortStackByStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        sortStackByStack(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            int cur = stack.pop();
            while (!help.empty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.empty()) {
            stack.push(help.pop());
        }
    }
}
