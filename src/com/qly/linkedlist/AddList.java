package com.qly.linkedlist;

import com.qly.linkedlist.nodes.Node;
import com.qly.linkedlist.nodes.PrintUtils;

import java.util.Stack;

/**
 * 两个单链表生成相加链表
 * 例如：9->3->7，代表 937；6->3，代表63。生成新的单链表 1->0->0->0。
 * <p>
 * 方法 1：
 * 显然可以用栈来求解，分别将两个单链表放入两个栈，然后栈顶相加。
 * 需要注意的是进位。令 ca = n/10，这样保证一旦相加大于 10，可以记录进位。
 * <p>
 * 方法 2：
 * 利用链表的逆序求解，先将两个单链表分别逆序，计算完成后再还原。
 *
 * @author qly
 */
public class AddList {
    public Node addList1(Node head1, Node head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null) {
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.value);
            head2 = head2.next;
        }
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while (!s1.empty() || !s2.empty()) {
            n1 = s1.empty() ? 0 : s1.pop();
            n2 = s2.empty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

    public Node addList2(Node head1, Node head2) {
        head1 = reverseNode(head1);
        head2 = reverseNode(head2);
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node c1 = head1;
        Node c2 = head2;
        Node node = null;
        Node pre = null;
        while (c1 != null || c2 != null) {
            n1 = c1 == null ? 0 : c1.value;
            n2 = c2 == null ? 0 : c2.value;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
            c1 = c1 == null ? null : c1.next;
            c2 = c2 == null ? null : c2.next;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        reverseNode(head1);
        reverseNode(head2);
        return node;
    }

    public Node reverseNode(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head1 = new Node(9);
        head1.next = new Node(3);
        head1.next.next = new Node(7);
        Node head2 = new Node(6);
        head2.next = new Node(3);
        AddList al = new AddList();
        PrintUtils.printBasic(al.addList2(head1, head2));
    }
}
