package com.qly.leetcode.week01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 239. 滑动窗口最大值
 *
 * @author qlylv
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        //List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 维护队头，何时出界，出界即删除
            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.pollFirst();
            }
            // 维护队列的单调性，本题需要维护单调递减的队列。num[i-1] <= num[i]则将i-1抛弃
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 元素入队
            deque.addLast(i);
            if (i >= k - 1) {
                //list.add(nums[deque.getFirst()]);
                ans[i - k + 1] = nums[deque.getFirst()];
            }
        }
        //return list.stream().mapToInt(Integer::valueOf).toArray();
        return ans;
    }

}
