package com.qly.leetcode.week08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * acwing145. 超市
 *
 * @author qlylv
 */
public class Supermarket {

    int[] fa;

    public int find(int i) {
        if (i == fa[i]) {
            return i;
        }
        return fa[i] = find(fa[i]);
    }

    private int solve(List<Node> list) {
        fa = new int[10001];
        for (int i = 0; i < 10001; i++) {
            fa[i] = i;
        }
        list.sort(Comparator.comparingInt(a -> a.profit));
        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int profit = list.get(i).profit;
            int day = list.get(i).day;
            int lastDay = find(day);
            if (lastDay > 0) {
                ans += profit;
                fa[lastDay] = lastDay - 1;
            }
        }
        return ans;
    }

    private final Scanner input = new Scanner(System.in);

    void run() {
        while (input.hasNext()) {
            int n = input.nextInt();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int p = input.nextInt();
                int d = input.nextInt();
                list.add(new Node(p, d));
            }
            System.out.println(solve(list));
        }
    }

    static class Node {
        // 利润
        int profit;
        // 过期时间
        int day;

        public Node(int profit, int day) {
            this.profit = profit;
            this.day = day;
        }

    }

    public static void main(String[] args) {
        Supermarket sm = new Supermarket();
        sm.run();
    }

}
