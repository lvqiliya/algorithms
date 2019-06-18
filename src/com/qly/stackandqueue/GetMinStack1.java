package com.qly.stackandqueue;

import java.util.Stack;

/**
 * 设计思想：
 * 用两个栈来实现，一个栈用来保存当前栈中的元素，其功能和正常的栈没有区别，记为 stackData；
 * 另一个栈用来保存每一步的最小值，记为 stackMin。
 * <p>
 * 第一种设计方案：
 * <p>
 * 压入规则
 * 假设当前数据为 newNum，先将其压入 stackData，然后判断 stackMin 是否为空。
 * 为空，则压入 newNum；不为空，则与 stackMin 栈顶元素进行比较。若 newNum 小于或等于栈顶元素，则压入；否则不压入任何内容
 * <p>
 * 弹出规则
 * 先在 stackData 中弹出栈顶元素，记为 value。然后比较当前 stackMin 的栈顶元素和 value 哪一个更小。
 * 由压入规则得知，stackMin 中存在的元素是从栈底到栈顶逐渐变小的，stackMin 栈顶的元素既是 stackMin 栈的最小值，也是当前 stackData 栈的最小值。
 * 所以 value 只会大于或等于 stackMin 的栈顶元素。
 * 当 value 等于 stackMin 的栈顶元素时，弹出；否则返回 value。
 *
 * @author qly
 */
public class GetMinStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStack1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.empty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.stackMin.peek()) {
            this.stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.empty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        int value = this.stackData.pop();
        if (value == this.stackMin.peek()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.stackMin.empty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        GetMinStack1 getMinStack1 = new GetMinStack1();
        getMinStack1.push(3);
        getMinStack1.push(4);
        getMinStack1.push(5);
        getMinStack1.push(1);
        getMinStack1.push(2);
        getMinStack1.push(1);
        System.out.println("The min number in the stack is " + getMinStack1.getMin());
        while (!getMinStack1.stackMin.empty()) {
            System.out.println(getMinStack1.stackMin.pop());
        }
    }
}
