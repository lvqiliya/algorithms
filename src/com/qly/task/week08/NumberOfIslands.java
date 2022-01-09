package com.qly.task.week08;

/**
 * 200. 岛屿数量
 *
 * 解题思路
 * 并查集解题，三个基本操作makeSet、unionSet、find
 * 遍历所有的岛屿，将可以联通的岛屿进行合并，最终答案就是多少棵树
 *
 * @author qlylv
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.unionSet(i * n + j, (i - 1) * n + j);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.unionSet(i * n + j, (i + 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.unionSet(i * n + j, i * n + j - 1);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.unionSet(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }

    static class UnionFind {
        int count;
        int[] fa;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            fa = new int[m * n];
            rank = new int[m * n];
            // 遍历二维网格
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    // 如果该坐标处是小岛，那么将小岛初始化，即makeSet操作
                    if (grid[i][j] == '1') {
                        fa[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public void unionSet(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                // 大树的根作为合并后的根，小树合并到大树上面去，通过rank数量来判断数的大小
                // rank[rootX] > rank[rootY]表示rootX的数量更大，将rootY的father改为rootX
                // rank[rootX] < rank[rootY]表示rootY的数量更大，将rootX的father改为rootY
                if (rank[rootX] > rank[rootY]) {
                    fa[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    fa[rootX] = rootY;
                } else {
                    // 尚未合并的情况下，将rootY的father改为rootX，此时rootX为根的数的数量+1
                    fa[rootY] = rootX;
                    rank[rootX] += 1;
                }
                --count;
            }
        }

        public int find(int i) {
            if (i == fa[i]) {
                return i;
            }
            return fa[i] = find(fa[i]);
        }

        public int getCount() {
            return count;
        }
    }

}
