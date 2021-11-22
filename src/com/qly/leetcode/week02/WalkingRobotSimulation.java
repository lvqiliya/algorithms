package com.qly.leetcode.week02;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 *
 * @author qlylv
 */
public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(calcHash(obstacle));
        }
        // 数据化方向
        int x = 0, y = 0;
        // N-0, E-1, S-2, W-3
        int dir = 0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        for (int command : commands) {
            if (command == -2) {
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (set.contains(calcHash(new int[]{nx, ny}))) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }

    private int calcHash(int[] obstacle) {
        return (obstacle[0] + 30000) * 60001 + (obstacle[1] + 30000);
    }

}
