package com.qly.leetcode.week04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 *
 * @author qlylv
 */
public class NumberOfIslands {

    private boolean[][] visited;
    private int ans, m, n;

    public int numIslands(char[][] grid) {
        // 行
        m = grid.length;
        // 列
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void bfs(char[][] grid, int sx, int sy) {
        final int[] dx = {-1, 0, 0, 1};
        final int[] dy = {0, -1, 1, 0};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sx * n + sy);
        while (!queue.isEmpty()) {
            // 第一步：队头出列
            int id = queue.remove();
            int x = id / n;
            int y = id % n;
            // 第二步：扩展对头
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] != '1') {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                queue.add(nx * n + ny);
                visited[nx][ny] = true;
            }
        }
        visited[sx][sy] = true;
    }

}
