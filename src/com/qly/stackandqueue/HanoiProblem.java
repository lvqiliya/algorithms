package com.qly.stackandqueue;

public class HanoiProblem {

    public static void main(String[] args) {
        String left = "left";
        String mid = "mid";
        String right = "right";
        move(4, left, mid, right);
        System.out.println(steps);
    }

    private static int steps;

    public static void move(int n, String left, String mid, String right) {
        steps++;
        if (n == 1) {
            System.out.println("Move 1 from " + left + " to " + right);
        } else {
            move(n - 1, left, right, mid);
            System.out.println("Move " + n + " from " + left + " to " + right);
            move(n - 1, mid, left, right);
        }
    }
}
