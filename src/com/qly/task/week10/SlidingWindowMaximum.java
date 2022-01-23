package com.qly.task.week10;

import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * <p>
 * 题目要求：使用有序集合解决
 *
 * @author qlylv
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 定义优先队列
        // 存入二元组，元素 num 以及在它数组中的下标 index
        // 如果元素不相等，元素更大的在前面；如果元素相等，下标更大的在前面
        // 保持堆顶元素是最大值，即大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        // 将元素放入优先队列中
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek() != null ? pq.peek()[0] : 0;
        // 动态放入元素到优先队列并从队列中出队无用元素
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while ((pq.peek() != null ? pq.peek()[1] : 0) <= i - k) {
                pq.poll();
            }
            // 每完成一次滑动就将当前根的值放入结果数组中
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

}
