package com.qly.task.week01;

/**
 * 21. 合并两个有序链表
 * <p>
 * 题目要求
 * 要将两个升序链表合并为一个新的 升序 链表并返回
 * <p>
 * 题目分析
 *
 * @author qlylv
 */
public class MergeTwoSortedLists {

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
