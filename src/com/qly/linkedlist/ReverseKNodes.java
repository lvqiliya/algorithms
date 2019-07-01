package com.qly.linkedlist;

import com.qly.linkedlist.nodes.Node;

import java.util.Stack;

/**
 * 将单链表的每 K 个节点之间逆序
 * 给定一个单链表的头节点 head，实现一个调整单链表的函数，使得每 K 个节点之间逆序。
 * 如果最后不够 K 个节点一组，则不调整最后几个节点。
 * <p>
 * 方法 1：
 * 将 K 个节点放入栈中，然后出栈进行连接。
 * <p>
 * 方法 2：
 * 在原链表中直接调整。
 *
 * @author qly
 */
public class ReverseKNodes {
    public Node reverseKNodes1(Node head, int K) {
        if (K < 2) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == K) {
                newHead = newHead == head ? cur : newHead;
                pre = resign1(stack, pre, next);
            }
            cur = next;
        }
        return newHead;
    }

    public Node resign1(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }
        Node next = null;
        while (!stack.empty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    public Node reverseKNodes2(Node head, int K) {
        if (K < 2) {
            return head;
        }
        Node pre = null;
        Node next = null;
        Node start = null;
        Node cur = head;
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == K) {
                head = pre == null ? cur : head;
                start = pre == null ? head : pre.next;
                resign2(start, cur, pre, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return null;
    }

    public void resign2(Node start, Node end, Node left, Node right) {
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }


}
