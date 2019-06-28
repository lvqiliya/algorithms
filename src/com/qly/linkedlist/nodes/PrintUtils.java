package com.qly.linkedlist.nodes;

/**
 * @author cupdata
 */
public class PrintUtils {
    public static void printBasic(Node node) {
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    public static void printSplitLine() {
        System.out.println("----------------");
    }
}
