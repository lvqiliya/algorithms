package com.qly;

import java.util.Stack;

/**
 * 设计思想：
 * 用两个栈来实现，一个栈用来保存当前栈中的元素，其功能和正常的栈没有区别，记为 stackData；
 * 另一个栈用来保存每一步的最小值，记为 stackMin。
 *
 * 第二种设计方案
 *
 * 压入规则
 * 假设当前数据为 newNum，先将其压入 stackData，然后判断 stackMin 是否为空。
 * 为空，则压入 newNum；不为空，则与 stackMin 栈顶元素进行比较。若 newNum 小于或等于栈顶元素，则压入；否则，压入栈顶元素
 *
 * 弹出规则
 * 在 stackData 中弹出数据，记为 value；弹出 stackMin 中的栈顶，返回 value。
 *
 * @author qly
 */
public class GetMinStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStack2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.empty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.stackMin.peek()) {
            this.stackMin.push(newNum);
        } else if (newNum > this.stackMin.peek()) {
            this.stackMin.push(this.stackMin.peek());
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.empty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.empty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        GetMinStack2 getMinStack2 = new GetMinStack2();
        getMinStack2.push(3);
        getMinStack2.push(4);
        getMinStack2.push(5);
        getMinStack2.push(1);
        getMinStack2.push(2);
        getMinStack2.push(1);
        System.out.println("The min number in the stack is " + getMinStack2.getMin());
        while (!getMinStack2.stackMin.empty()) {
            System.out.println(getMinStack2.stackMin.pop());
        }
    }
}
