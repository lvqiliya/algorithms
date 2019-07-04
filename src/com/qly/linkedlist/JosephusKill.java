package com.qly.linkedlist;

import com.qly.linkedlist.nodes.Node;

/**
 * 环形单链表的约瑟夫问题。报数为 m，从第头开始报数，为 m 的节点删除。
 *
 * 普通方法：
 * 目标是只要这个环形单链表只剩下一个节点，那么就完成算法。
 * 最后的这一个节点既是头节点也是尾节点。这是遍历结束的条件。
 *
 *
 * @author qly
 */
public class JosephusKill {
    public Node josephusKill1(Node head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = head;
        Node cur = head;
        for (int i = 2; i < 6; i++) {
            cur.next = new Node(i);
            cur.next.next = head;
            cur = cur.next;
        }
        JosephusKill kill = new JosephusKill();
        System.out.println(kill.josephusKill1(head, 4));
    }
}
