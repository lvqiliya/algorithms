package com.qly.stackandqueue;

public class HanoiProblem1 {
    public static void main(String[] args) {
        String left = "left";
        String mid = "mid";
        String right = "right";
        String orig = "left";
        String dest = "right";
        int n = 4;
        int p = move(n, left, mid, right, orig, dest);
        System.out.println(p);


    }

    public static int move(int n, String left, String mid, String right, String orig, String dest) {
        boolean isMid = orig.equals(mid) || dest.equals(mid);
        if (n == 1) {
            if (isMid) {
                System.out.println("Move 1 from " + orig + " to " + dest);
                return 1;
            } else {
                System.out.println("Move 1 from " + orig + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + dest);
                return 2;
            }
        }
        if (isMid) {
            String temp = orig.equals(left) || dest.equals(left) ? right : left;
            int p1 = move(n - 1, left, mid, right, orig, temp);
            System.out.println("Move " + n + " from " + orig + " to " + dest);
            int p2 = move(n - 1, left, mid, right, temp, dest);
            return p1 + p2 + 1;
        } else {
            int p1 = move(n - 1, left, mid, right, orig, dest);
            System.out.println("Move " + n + " from " + orig + " to " + mid);
            int p2 = move(n - 1, left, mid, right, dest, orig);
            System.out.println("Move " + n + " from " + mid + " to " + dest);
            int p3 = move(n - 1, left, mid, right, orig, dest);
            return p1 + p2 + p3 + 2;
        }
    }
}
