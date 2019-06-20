package com.qly.linkedlist;

import com.qly.linkedlist.nodes.Node;

/**
 * 给定一个单向链表的头节点 head，以及两个整数 from 和 to，
 * 在单向链表上把第 from 个节点到第 to 个节点这一部分进行反转。
 *
 * 要求，若不满足 1<=from<=to=N，则不用调整
 *
 * @author qly
 */
public class ReversePart {
    public Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node fPre = null;
        Node tPos = null;
        Node cur = head;
        while (cur != null) {
            len++;
            fPre = len == from - 1 ? cur : fPre;
            tPos = len == to + 1 ? cur : tPos;
            cur = cur.next;
        }
        if (to < from || from < 1 || to > len) {
            return head;
        }
        cur = fPre == null ? head : fPre.next;
        Node temp = cur.next;
        cur.next = tPos;
        Node next;
        while (temp != tPos) {
            next = temp.next;
            temp.next = cur;
            cur = temp;
            temp = next;
        }
        if (fPre != null) {
            fPre.next = cur;
            return head;
        }
        return cur;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node cur1 = head1;
        for (int i = 2; i < 6; i++) {
            cur1.next = new Node(i);
            cur1 = cur1.next;
        }
        ReversePart list = new ReversePart();
        Node res = list.reversePart(head1,2,4);
        while (res != null) {
            System.out.println(res);
            res = res.next;
        }
    }
}
