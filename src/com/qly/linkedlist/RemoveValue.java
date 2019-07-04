package com.qly.linkedlist;

import com.qly.linkedlist.nodes.Node;
import com.qly.linkedlist.nodes.PrintUtils;

import java.util.Stack;

/**
 * 在单链表中删除指定值的节点
 *
 * 方法 1：
 * 1. 用一个栈来存储所有的节点，入栈之前进行比较，相等则删除。
 * 2. 入栈完成之后重新生成单链表。
 *
 * 方法 2：
 * 1. 首先找到第一个不为该值的节点，设为新的头节点；
 * 2. 然后进行遍历单链表并比较，相等则使 pre.next = cur.next，否则则使 pre = cur；
 *
 * @author qly
 */
public class RemoveValue {
    public Node removeValue1(Node head, int value) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.value != value) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.empty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    public Node removeValue2(Node head, int value) {
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node cur = head;
        for (int i = 2; i < 5; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = new Node(2);
        PrintUtils.printBasic(head);
        PrintUtils.printSplitLine();
        RemoveValue r = new RemoveValue();
        PrintUtils.printBasic(r.removeValue2(head, 2));
    }
}
