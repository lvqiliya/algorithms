package com.qly.leetcode.week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 *
 * @author qlylv
 */
public class CourseSchedule {

    private List<List<Integer>> to;
    private int[] inDeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建图
        to = new ArrayList<>(numCourses);
        inDeg = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            to.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int ai = pre[0];
            int bi = pre[1];
            to.get(bi).add(ai);
            inDeg[ai]++;
        }
        // 拓扑排序第一步：从零入度点开始
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> lessons = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            lessons.add(x);
            // 拓扑排序第二步：周围点入度减一
            for (int y : to.get(x)) {
                inDeg[y]--;
                // 拓扑排序第三步：入度为0，可以入队
                if (inDeg[y] == 0) {
                    queue.add(y);
                }
            }
        }
        return lessons.size() == numCourses;
    }

}
