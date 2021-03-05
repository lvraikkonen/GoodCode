package com.claus.DP;

import java.util.Arrays;

public class leetcode_322_Coin_Change {
    public static int coinChange(int[] coins, int amount) {
        // dp 数组的定义：当目标金额为 i 时，需要的最小硬币数
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i-coin < 0) {
                    // 子问题无解，跳过
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }

        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int res = coinChange(coins, 11);
    }
}
