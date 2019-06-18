package com.qly.stackandqueue;

import java.util.Stack;

/**
 * @author qly
 */
public class ReverseStackByRecursive {

    private static int i = 1;

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int peek = stack.pop();
        if (stack.empty()) {
            return peek;
        } else {
            int beek = getAndRemoveLastElement(stack);
            stack.push(peek);
            return beek;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Before running reverse() the peek is " + stack.peek());
        ReverseStackByRecursive.reverse(stack);
        System.out.println("After running reverse() The peek is " + stack.peek());
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}
