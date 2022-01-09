package com.qly.task.week08;

/**
 * 684. 冗余连接
 * <p>
 * 解题思路
 * 并查集解题，三个基本操作makeSet、unionSet、find
 *
 * @author qlylv
 */
public class RedundantConnection {

    private int[] fa;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        fa = new int[n + 1];
        // MakeSet
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            // 首先取寻找两个元素的根节点是否相同，如果不相同，那么进行unionSet操作
            // 否则，说明它们具有相同根root，此时root分别和x、y相连，而x和y本就相连，所以形成了环，返回[x, y]即可
            if (find(x) != find(y)) {
                unionSet(x, y);
            } else {
                return edge;
            }
        }
        return new int[0];
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
