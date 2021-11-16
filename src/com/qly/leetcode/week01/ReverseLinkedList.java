package com.qly.leetcode.week01;

/**
 * 206. 反转链表
 *
 * @author qlylv
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        // 遍历链表
        while (head != null) {
            ListNode node = head.next;
            head.next = prev;
            prev = head;
            head = node;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}


