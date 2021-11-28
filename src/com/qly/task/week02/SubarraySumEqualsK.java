package com.qly.task.week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 *
 * @author qlylv
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        // 先求前缀和数组
        int len = nums.length;
        int[] sums = new int[len + 1];
        sums[0] = 0;
        for (int i = 0; i < len; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        // 双层遍历前缀和数组找到连续子数组的个数
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (k == sums[j + 1] - sums[i]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int subarraySum2(int[] nums, int k) {
        int preSum = 0, ans = 0;
        // key-前缀和，value-出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            // 前缀和计算
            preSum += num;
            // 当遍历到本数时，前缀和数组中正好存在连续子数组之和为k。
            // 举例：遍历到本数时，前缀和数组 => [a, b, c, d]
            // 此时 d - a = k，移项可得 a = d - k，即 a = preSum - k
            // 假设没有 if 这段逻辑，正常的前缀和数组进行散列的逻辑则是 map.put(key-前缀和，value-出现的次数)
            // 如果 a = preSum - k 存在于 map 中，说明连续子数组之和为k的情况存在，累计到 ans 即可
            if (map.containsKey(preSum - k)) {
                ans += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }

}
