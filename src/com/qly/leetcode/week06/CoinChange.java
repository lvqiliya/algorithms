package com.qly.leetcode.week06;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * @author qlylv
 */
public class CoinChange {

    /**
     * coinChange
     *
     * @param coins  不同面额的硬币
     * @param amount 总金额
     * @return 最少的硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int[] opt = new int[amount + 1];
        Arrays.fill(opt, amount + 1);
        opt[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    opt[i] = Math.min(opt[i], opt[i - coins[j]] + 1);
                }
            }
        }
        return opt[amount] > amount ? -1 : opt[amount];
    }

}
