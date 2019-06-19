package com.qly.linkedlist;

import com.qly.linkedlist.nodes.DoubleNode;
import com.qly.linkedlist.nodes.Node;

/**
 * 分别实现两个函数，一个可以删除单链表中倒数第 K 个节点，另一个可以删除双链表中的倒数第 K 个节点。
 * <p>
 * 牢记：想要删除节点，必须找到它的前一节点。
 * 若有 5 个节点，要删除倒数第 1 个节点，那么这个节点的前一个节点是第 5 - 1 = 4 个节点；
 * 若有 5 个节点，要删除倒数第 3 个节点，那么这个节点的前一个节点是第 5 - 3 = 2 个节点。
 * 所以前一节点是第 N-K 个节点。
 * <p>
 * 双线链表需要注意 prev 指针的重连。
 *
 * @author qly
 */
public class RemoveLastKthNode {
    public Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        // 循环结束，K 的值变成 K - N
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.prev = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.prev = cur;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(0);
        Node cur1 = head1;
        for (int i = 1; i < 5; i++) {
            cur1.next = new Node(i);
            cur1 = cur1.next;
        }
        RemoveLastKthNode demo1 = new RemoveLastKthNode();
        Node res1 = demo1.removeLastKthNode(head1, 3);
        while (res1 != null) {
            System.out.println(res1);
            res1 = res1.next;
        }
        System.out.println("----------");
        DoubleNode head2 = new DoubleNode(0);
        DoubleNode cur2 = head2;
        for (int i = 1; i < 5; i++) {
            cur2.next = new DoubleNode(i);
            cur2.next.prev = cur2;
            cur2 = cur2.next;
        }
        RemoveLastKthNode demo2 = new RemoveLastKthNode();
        DoubleNode res2 = demo2.removeLastKthNode(head2, 2);
        while (res2 != null) {
            System.out.println(res2);
            res2 = res2.next;
        }
    }
}
