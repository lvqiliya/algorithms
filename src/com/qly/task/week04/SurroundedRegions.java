package com.qly.task.week04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. 被围绕的区域
 * 解释说明：
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 解题思路
 * 找到边界上的'O'点，然后开始向内扩展，与岛屿数量一样，使用BFS解题
 * 同样的也可以使用DFS解题，找到递归边界就可以
 *
 * @author qlylv
 */
public class SurroundedRegions {

    private final int[] dx = {-1, 0, 0, 1};
    private final int[] dy = {0, -1, 1, 0};
    private int m, n;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        // 行
        m = board.length;
        // 列
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边界为 'O' 开始搜索，第一行、第一列、最后一行、最后一列，四周
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (board[i][j] == 'O' && isEdge) {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int sx, int sy) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sx * n + sy);
        board[sx][sy] = 'Y';
        while (!queue.isEmpty()) {
            // 第一步：队头出列
            int pos = queue.poll();
            int x = pos / n;
            int y = pos % n;
            // 第二部：扩展队头
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 如果出界了，那么就直接返回
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                // 如果找到的不是'O'，也直接返回
                if (board[nx][ny] != 'O') {
                    continue;
                }
                queue.add(nx * n + ny);
                board[nx][ny] = 'Y';
            }
        }
    }

    private void dfs(char[][] board, int sx, int sy) {
        // 递归边界
        if (sx < 0 || sy < 0 || sx >= m || sy >= n || board[sx][sy] == 'X' || board[sx][sy] == 'Y') {
            return;
        }
        // 递归逻辑
        board[sx][sy] = 'Y';
        for (int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            dfs(board, nx, ny);
        }
    }

}
