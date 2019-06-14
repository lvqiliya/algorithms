package com.qly;

import java.util.Stack;

/**
 * 题目要求：
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）。
 * <p>
 * 设计思路：
 * 用两个栈正好能把顺序反过来实现类似队列的操作。一个栈作为压入栈，在压入数据时，只往这个栈压入，记为 stackPush；
 * 另一个栈作为弹出栈，在弹出数据时只从这个栈弹出，记为 stackPop。
 * 先将数据压入 stackPush，再将数据整体压入 stackPop，完成队列的进；然后将数据弹出，完成队列的出。
 * <p>
 * 注意：
 * 1. 如果 stackPush 要往 stackPop 中压入数据，必须一次性把 stackPush 栈中的数据全部压入 stackPop。
 * 2. 如果 stackPop 不为空，stackPush 不能向 stackPop 中压入数据。
 * <p>
 * 设计实现：
 *
 * @author qly
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    private void pushToPop() {
        if (this.stackPop.empty()) {
            while (!this.stackPush.empty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }
    }

    public void add(int[] list) {
        for (Integer i : list) {
            this.stackPush.push(i);
        }
        pushToPop();
    }

    public int poll() {
        if (this.stackPush.empty() && this.stackPop.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return this.stackPop.pop();
    }

    public int peek() {
        if (this.stackPush.empty() && this.stackPop.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return this.stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.add(new int[]{1, 2, 3, 4, 5});
        System.out.println("The list peek is " + queue.peek());
        while (!queue.stackPop.empty()) {
            System.out.println(queue.poll());
        }
    }
}
