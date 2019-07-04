package com.qly.linkedlist;

import com.qly.linkedlist.nodes.Node;

import java.util.HashSet;

/**
 * 删除无序单链表中值重复出现的节点
 *
 * 方法 1：
 * HashSet 中的值是不会重复的。
 * 1. 放入头节点的值到 HashSet；
 * 2. 遍历到第二个节点，判断 HashSet 中是否含有当前节点的值；
 * 3. 含有当前值，让前一个节点去链接后一个节点，即 pre.next = cur.next；
 * 4. 不含有当前值，放入 HashSet，并后移前一个节点；
 * 5. 重复 2 至 4 步骤。
 *
 * 方法 2：
 * 取到当前节点的值，遍历单链表所有节点，删除相同值的节点。
 * 1. 令 cur 为头节点，令 pre 为头节点，令 next = cur.next；
 * 2. 遍历所有节点，cur.value == next.value ? pre.next = next.next : pre = next；
 *
 * @author qly
 */
public class RemoveRep {
    public Node removeRep1(Node head) {
        HashSet<Integer> hashSet = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        hashSet.add(head.value);
        while (cur != null) {
            if (hashSet.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                hashSet.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public Node removeRep2(Node head) {
        Node cur = head;
        Node pre;
        Node next;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node cur = head;
        for (int i = 2; i < 7; i++) {
            cur.next = new Node(i % 2 + i / 2 + 1);
            cur = cur.next;
        }
        cur.next = new Node(2);
        cur = cur.next;
        cur.next = new Node(1);
        cur = cur.next;
        cur.next = new Node(1);
        cur = head;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
        System.out.println("----------------");
        RemoveRep r = new RemoveRep();
        cur = r.removeRep2(head);
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
}
