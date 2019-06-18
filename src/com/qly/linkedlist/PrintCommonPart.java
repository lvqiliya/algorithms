package com.qly.linkedlist;

/**
 * 给定两个有序链表的头指针 head1 和 head2，打印这两个链表的公共部分。
 *
 * 实现思路：
 * 1. 如果 head1 的值小于 head2，则 head1 往下移动。
 * 2. 如果 head2 的值小于 head1，则 head2 往下移动。
 * 3. 如果 head1 的值等于 head2 的值，则打印这个值，然后 head1 和 head2 同时往下移。
 * 4. head1 或 head2 有任何一个移动到 null 时，则整个过程停止。
 *
 * @author qly
 */
public class PrintCommonPart {
    public class Node {
        public int value;
        public Node next;

        public Node() {}

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void printCommonPart(Node head1, Node head2) {
        System.out.print("Print common : ");
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
}
