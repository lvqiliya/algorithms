package com.qly.linkedlist;

import com.qly.linkedlist.nodes.Node;

/**
 * 给定链表的头节点 head，实现删除链表的中间节点函数。
 * 例如：
 * 不删除任何节点；
 * 1->2，删除节点 1；
 * 1->2->3，删除节点 2；
 * 1->2->3->4，删除节点 2；
 * 1->2->3->4->5，删除节点 3；
 * <p>
 * 进阶：
 * 给定链表的头节点 head、整数 a 和 b，实现删除位于 a/b 处节点的函数。
 * 例如：
 * 链表：1->2->3->4->5，假设 a/b 的值为 r。
 * 如果 r = 0，不删除任何节点；
 * 如果 r 落在区间 (0, 1/5]，删除节点 1；
 * 如果 r 落在区间 (1/5, 2/5]，删除节点 2；
 * 如果 r 落在区间 (2/5, 3/5]，删除节点 3；
 * 如果 r 落在区间 (3/5, 4/5]，删除节点 4；
 * 如果 r 落在区间 (4/5, 1]，删除节点 5；
 * 如果 r > 1，不删除任何节点。
 * 经过论证，被删除节点的计算方法是 double r = (double) (a * n) / (double) b 然后向上取整。
 *
 * @author qly
 */
public class RemoveMidNode {
    public Node removeMid(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a * n)) / (double) b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(0);
        Node cur1 = head1;
        for (int i = 1; i < 6; i++) {
            cur1.next = new Node(i);
            cur1 = cur1.next;
        }
        cur1 = head1;
        while (cur1 != null) {
            System.out.println(cur1);
            cur1 = cur1.next;
        }
        System.out.println("----------");
        RemoveMidNode demo1 = new RemoveMidNode();
        cur1 = demo1.removeMid(head1);
        while (cur1 != null) {
            System.out.println(cur1);
            cur1 = cur1.next;
        }
        System.out.println("**********");
        Node head2 = new Node(1);
        Node cur2 = head2;
        for (int i = 2; i < 6; i++) {
            cur2.next = new Node(i);
            cur2 = cur2.next;
        }
        cur2 = head2;
        while (cur2 != null) {
            System.out.println(cur2);
            cur2 = cur2.next;
        }
        System.out.println("----------");
        RemoveMidNode demo2 = new RemoveMidNode();
        cur2 = demo2.removeByRatio(head2, 2, 1);
        while (cur2 != null) {
            System.out.println(cur2);
            cur2 = cur2.next;
        }
    }
}
