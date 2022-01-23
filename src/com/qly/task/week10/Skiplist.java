package com.qly.task.week10;

/**
 * 1206. 设计跳表
 *
 * @author qlylv
 */
public class Skiplist {

    /**
     * 最大层数
     */
    private static final int MAX_LEVEL = 16;
    /**
     * 随机层数概率
     * 随机的层数，在第 1 层以上的概率，层数不超过 maxLevel，层数的起始号为 1
     */
    private static final double DEFAULT_FACTOR = 0.5;

    private final Node head = new Node(null, MAX_LEVEL);

    private int level = 1;

    public Skiplist() {
    }

    public boolean search(int target) {
        Node node = head;
        for (int i = level - 1; i >= 0; i--) {
            node = findSuffix(node, i, target);
            if (node.next[i] != null && node.next[i].value == target) {
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        int level = randomLevel();
        Node node = head;
        Node newNode = new Node(num, level);
        // 计算出当前 num 索引的实际层数，从该层开始添加索引
        for (int i = this.level - 1; i >= 0; i--) {
            // 找到本层最近离 num 最近的 list
            node = findSuffix(node, i, num);
            if (i < level) {
                if (node.next[i] == null) {
                    node.next[i] = newNode;
                } else {
                    Node temp = node.next[i];
                    node.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        // 如果随机出来的层数比当前的层数还大，那么超过 level 的 head 直接指向 newNode
        if (level > this.level) {
            for (int i = this.level; i < level; i++) {
                head.next[i] = newNode;
            }
            this.level = level;
        }

    }

    public boolean erase(int num) {
        boolean flag = false;
        Node node = head;
        for (int i = level - 1; i >= 0; i--) {
            node = findSuffix(node, i, num);
            if (node.next[i] != null && node.next[i].value == num) {
                node.next[i] = node.next[i].next[i];
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 找到 level 层 value 大于 node 的节点
     */
    private Node findSuffix(Node node, int levelIndex, int value) {
        while ((node.next[levelIndex]) != null && value > node.next[levelIndex].value) {
            node = node.next[levelIndex];
        }
        return node;
    }


    /**
     * 随机层数
     */
    private static int randomLevel() {
        int level = 1;
        while (Math.random() < DEFAULT_FACTOR && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }


    static class Node {
        Integer value;
        Node[] next;

        public Node(Integer value, int size) {
            this.value = value;
            this.next = new Node[size];
        }
    }

}