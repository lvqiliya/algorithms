package com.qly.leetcode.week01;

/**
 * 25. K 个一组翻转链表
 *
 * @author qlylv
 */
public class ReverseK {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect = new ListNode(0, head);
        ListNode prev = protect;
        // 分组遍历
        while (head != null) {
            // 1.分组，往后走k-1步，找一组（开头的head，结尾的tail）
            ListNode tail = getTail(head, k);
            if (tail == null) {
                break;
            }
            ListNode nextGroupHead = tail.next;
            // 2.组内内部反转
            reverseList(head, nextGroupHead);
            // 3.各组边界连接，前一组 + 后一组
            // 3.1 前一组
            prev.next = tail;
            // 3.2 后一组
            head.next = nextGroupHead;
            prev = head;
            head = nextGroupHead;
        }
        return protect.next;
    }

    private ListNode getTail(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    private void reverseList(ListNode head, ListNode nextStopHead) {
        ListNode prev = head;
        head = head.next;
        // 遍历链表
        while (head != nextStopHead) {
            ListNode node = head.next;
            head.next = prev;
            prev = head;
            head = node;
        }
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
