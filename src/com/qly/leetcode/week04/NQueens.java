package com.qly.leetcode.week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 51. N 皇后
 *
 * @author qlylv
 */
public class NQueens {

    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> perm = new ArrayList<>();
    private final Set<Integer> used = new HashSet<>();
    private final Set<Integer> usedPlus = new HashSet<>();
    private final Set<Integer> usedMinus = new HashSet<>();
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        dfs(0);
        return ans;
    }

    private void dfs(int row) {
        if (row == n) {
            ans.add(new ArrayList<>(format(perm, n)));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (used.contains(col)) {
                continue;
            }
            int sum = row + col;
            if (usedPlus.contains(sum)) {
                continue;
            }
            int diff = row - col;
            if (usedMinus.contains(diff)) {
                continue;
            }
            perm.add(String.valueOf(col));
            used.add(col);
            usedPlus.add(sum);
            usedMinus.add(diff);
            dfs(row + 1);
            // 还原现场
            usedMinus.remove(diff);
            usedPlus.remove(sum);
            used.remove(col);
            perm.remove(String.valueOf(col));
        }
    }

    private List<String> format(List<String> perm, int n) {
        List<String> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[Integer.parseInt(perm.get(i))] = 'Q';
            q.add(new String(row));
        }
        return q;
    }

}
