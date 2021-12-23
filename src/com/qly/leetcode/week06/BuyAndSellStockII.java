package com.qly.leetcode.week06;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author qlylv
 */
public class BuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i-1], 0);
        }
        return ans;
    }

}
