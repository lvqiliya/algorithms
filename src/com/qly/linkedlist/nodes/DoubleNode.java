package com.qly.linkedlist.nodes;

public class DoubleNode {
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
