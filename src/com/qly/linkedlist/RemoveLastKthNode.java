package com.qly.linkedlist;

/**
 * 分别实现两个函数，一个可以删除单链表中倒数第 K 个节点，另一个可以删除双链表中的倒数第 K 个节点。
 * <p>
 * 牢记：想要删除节点，必须找到它的前一节点。
 * 若有 5 个节点，要删除倒数第 1 个节点，那么这个节点的前一个节点是第 5 - 1 = 4 个节点；
 * 若有 5 个节点，要删除倒数第 3 个节点，那么这个节点的前一个节点是第 5 - 3 = 2 个节点。
 * 所以前一节点是第 N-K 个节点。
 *
 * 双线链表需要注意 prev 指针的重连。
 * @author qly
 */
public class RemoveLastKthNode {
    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(0);
        DoubleNode cur = head;
        for (int i = 1; i < 5; i++) {
            cur.next = new DoubleNode(i);
            cur.next.prev = cur;
            cur = cur.next;
        }
        Demo demo = new Demo();
        DoubleNode res = demo.removeLastKthNode(head, 3);
        while (res != null) {
            System.out.println(res);
            res = res.next;
        }
    }
}

class Node {
    public int value;
    public Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value = " + value + "]";
    }
}

class DoubleNode {
    public int value;
    public DoubleNode prev;
    public DoubleNode next;

    public DoubleNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoubleNode [value = " + value + "]";
    }
}

class Demo {
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
}
