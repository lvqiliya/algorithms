package com.qly.leetcode.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * 684. 冗余连接
 *
 *
 * @author qlylv
 */
public class RedundantConnection {

    private List<List<Integer>> to;
    private boolean[] visited;
    private boolean hasCycle;

    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            n = Math.max(n, Math.max(x, y));
        }
        to = new ArrayList<>(n + 1);
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            to.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            to.get(x).add(y);
            to.get(y).add(x);
            hasCycle = false;
            dfs(x, 0);
            if (hasCycle) {
                return edge;
            }
        }
        return null;
    }

    private void dfs(int x, int parent) {
        visited[x] = true;
        for (int y : to.get(x)) {
            if (y == parent) {
                continue;
            }
            if (!visited[y]) {
                dfs(y, x);
            } else {
                hasCycle = true;
            }
        }
        visited[x] = false;
    }

}
