package com.qly.leetcode.week06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @author qlylv
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return null;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            // 第i个区间的起点小于等于end
            if (interval[0] <= end) {
                // 选举第i个区间的终点和end为新end
                end = Math.max(end, interval[1]);
            } else {
                // 否则，将覆盖后的区间保存到答案
                list.add(new int[]{start, end});
                // 将现在遍历到的区间值赋值给起点和终点
                start = interval[0];
                end = interval[1];
            }
        }
        // 处理最后选举出来的起点和终点
        list.add(new int[]{start, end});
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
