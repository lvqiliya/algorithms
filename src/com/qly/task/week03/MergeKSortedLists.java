package com.qly.task.week03;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 要求：用分治实现，不要用堆
 *
 * 解题思路
 * 通过前面的学习，我们可以将两个升序链表进行合并
 * 现在有k个升序链表，利用分治法，将k个链表不断从中间拆分，直到简化为两个升序链表的合并。
 *
 * @author qlylv
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        // 递归边界
        if (left == right) {
            return lists[left];
        }
        // 递归逻辑 二分法拆分数组
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 使用保护节点用来访问新链表
        ListNode protect = new ListNode(Integer.MIN_VALUE);
        ListNode pre = protect;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 != null ? l1 : l2;
        return protect.next;
    }

    private ListNode mergeTwoListsByRecur(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsByRecur(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecur(l1, l2.next);
            return l2;
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
