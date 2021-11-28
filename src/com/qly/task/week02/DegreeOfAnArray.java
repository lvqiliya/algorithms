package com.qly.task.week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. 数组的度
 *
 * 使用HashMap将每个数进行处理
 *
 * @author qlylv
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list;
            if (map.containsKey(nums[i])) {
                list = map.get(nums[i]);
                list.set(0, list.get(0) + 1);
                list.set(2, i);
            } else {
                list = new ArrayList<>();
                list.add(1);
                list.add(i);
                list.add(i);
                map.put(nums[i], list);
            }
        }
        int maxNum = 0, minDu = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int curDu = list.get(2) - list.get(1) + 1;
            if (list.get(0) > maxNum) {
                maxNum = list.get(0);
                minDu = curDu;
            } else if (list.get(0) == maxNum  && minDu > curDu) {
                minDu = curDu;
            }
        }
        return minDu;
    }

}
