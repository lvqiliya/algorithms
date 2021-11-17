package com.qly.leetcode.week01;

/**
 * 141. 环形链表
 *
 * @author qlylv
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        // 采用快慢指针法
        // 1. 要出现环，至少为两个节点，所以先判断头节点和头节点的后继节点
        if (head == null || head.next == null) {
            return false;
        }
        // 2. 当快慢指针相遇的时候，则存在环
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            // ? 为什么需要判断快指针的后继节点（为了防止迭代语句出现NPE）
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
