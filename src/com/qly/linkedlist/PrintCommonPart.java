package com.qly.linkedlist;

import com.qly.linkedlist.nodes.Node;

/**
 * 给定两个有序链表的头指针 head1 和 head2，打印这两个链表的公共部分。
 * <p>
 * 实现思路：
 * 1. 如果 head1 的值小于 head2，则 head1 往下移动。
 * 2. 如果 head2 的值小于 head1，则 head2 往下移动。
 * 3. 如果 head1 的值等于 head2 的值，则打印这个值，然后 head1 和 head2 同时往下移。
 * 4. head1 或 head2 有任何一个移动到 null 时，则整个过程停止。
 *
 * @author qly
 */
public class PrintCommonPart {
    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Print common : ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(0);
        Node cur1 = head1;
        for (int i = 1; i < 5; i++) {
            cur1.next = new Node(i);
            cur1 = cur1.next;
        }
        Node head2 = new Node(2);
        Node cur2 = head2;
        for (int i = 3; i < 7; i++) {
            cur2.next = new Node(i);
            cur2 = cur2.next;
        }
        System.out.println("Linked list 1 :");
        cur1 = head1;
        while (cur1 != null) {
            System.out.println(cur1);
            cur1 = cur1.next;
        }
        System.out.println("Linked list 2 :");
        cur2 = head2;
        while (cur2 != null) {
            System.out.println(cur2);
            cur2 = cur2.next;
        }
        PrintCommonPart demo = new PrintCommonPart();
        demo.printCommonPart(head1, head2);
    }
}
