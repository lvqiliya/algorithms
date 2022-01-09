package com.qly.leetcode.week08;

/**
 * 547. 省份数量
 *
 * @author qlylv
 */
public class NumberOfProvinces {

    int[] fa;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionSet(i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                ans++;
            }
        }
        return ans;
    }

    private void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            fa[x] = y;
        }
    }

    private int find(int i) {
        if (i == fa[i]) {
            return i;
        }
        return fa[i] = find(fa[i]);
    }

}
