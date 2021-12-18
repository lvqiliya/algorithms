package com.qly.task.week05;

/**
 * 1011. 在 D 天内送达包裹的能力
 *
 * 解题思路
 * 此题和410.分割数组的最大值是同一类题型，只不过运用到了更具体的场景
 *
 * @author qlylv
 */
public class CapacityToShipPackages {

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            // 要想船的运输能力至少可以运一个数组元素的重量，那么最低运载能力就是数组中的最大值
            left = Math.max(left, weight);
            // 最差情况下，用一天就完成所有运输，那么船的运输能力就是数组之和
            right += weight;
        }
        // 二分判定
        while (left < right) {
            int mid = (left + right) / 2;
            // 校验重量数组是否能在运载能力为mid、天数为days中完成运输
            if (validate(weights, days, mid)) {
                // 装下了，说明没有用到days天就完成运输，此时每一天的运输能力并不是最小值
                right = mid;
            } else {
                // 装不下，说明盒子数m用完不够，那么盒子数m不变的情况下，只能扩大盒子容量mid
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 校验当重量数组拆分个days个子数组时，每一个子数组的和是否能在大小为capacity的最低运载能力下完成运输
     *
     * @param weights 重量数组
     * @param days    天数
     * @param capacity 最低运载能力
     * @return 是否能完成运输
     */
    private boolean validate(int[] weights, int days, int capacity) {
        int box = 0;
        int actualDays = 1;
        for (int weight : weights) {
            if (box + weight <= capacity) {
                box += weight;
            } else {
                // 第二天继续运
                actualDays++;
                box = weight;
            }
        }
        return actualDays <= days;
    }

}
