package com.qly.linkedlist;

import com.qly.linkedlist.nodes.DoubleNode;
import com.qly.linkedlist.nodes.Node;

/**
 * 分别实现反转单向链表和反转双向链表
 *
 * @author qly
 */
public class ReverseList {
    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public DoubleNode reverseList(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoubleNode prev = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node cur1 = head1;
        for (int i = 2; i < 6; i++) {
            cur1.next = new Node(i);
            cur1 = cur1.next;
        }
        ReverseList list = new ReverseList();
        Node res = list.reverseList(head1);
        while (res != null) {
            System.out.println(res);
            res = res.next;
        }
        System.out.println("----------");
        DoubleNode head2 = new DoubleNode(1);
        DoubleNode cur2 = head2;
        for (int i = 2; i < 6; i++) {
            cur2.next = new DoubleNode(i);
            cur2 = cur2.next;
        }
        DoubleNode res2 = list.reverseList(head2);
        while (res2 != null) {
            System.out.println(res2);
            res2 = res2.next;
        }
    }
}
