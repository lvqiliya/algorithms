package com.qly.stackandqueue;

public class ArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == n) {
            if (head == 0) {
                System.out.println("真的放不下了！");
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        System.out.printf("%s 入队成功，此时 tail = %d\n", item, tail);
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        return items[head++];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("5");
        arrayQueue.enqueue("4");
        arrayQueue.enqueue("3");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("0");
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayQueue.dequeue());
        }
        arrayQueue.enqueue("6");
        arrayQueue.enqueue("7");
        arrayQueue.enqueue("8");
        for (int i = 0; i < 5; i++) {
            System.out.println(arrayQueue.dequeue());
        }
    }
}
