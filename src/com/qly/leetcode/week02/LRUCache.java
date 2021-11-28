package com.qly.leetcode.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 *
 * @author qlylv
 */
public class LRUCache {

    private final int capacity;
    private NodeDoubleLinkedList nodeList;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodeList = new NodeDoubleLinkedList();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node res = map.get(key);
            nodeList.moveNodeToTail(res);
            return res.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            nodeList.moveNodeToTail(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            nodeList.addNode(newNode);
            if (map.size() == capacity + 1) {
                Node removeNode = nodeList.removeHead();
                if (removeNode != null) {
                    map.remove(removeNode.key);
                }
            }
        }
    }

    static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 设计实现一个双向链表，它包含以下方法
     * 1. 追加元素到tail
     * 2. 达到容量时，删除head
     * 3. 将任意元素移动到tail
     */
    static class NodeDoubleLinkedList {
        Node head;
        Node tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        private void addNode(Node node) {
            if (node == null) {
                return;
            }
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }

        private Node removeHead() {
            if (head == null) {
                return null;
            }
            Node res = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = res.next;
                res.next = null;
                head.pre = null;
            }
            return res;
        }

        private void moveNodeToTail(Node node) {
            if (tail == node) {
                return;
            }
            if (head == node) {
                head = head.next;
                head.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.pre = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }

    }

}
