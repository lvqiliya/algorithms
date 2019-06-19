package com.qly.linkedlist.nodes;

public class Node {
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
