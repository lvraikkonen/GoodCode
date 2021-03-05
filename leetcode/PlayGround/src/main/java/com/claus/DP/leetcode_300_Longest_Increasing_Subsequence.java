package com.claus.DP;

import java.util.Arrays;

public class leetcode_300_Longest_Increasing_Subsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // base case
        Arrays.fill(dp, 1);
        for (int i=0; i < nums.length; i++) {
            for (int j=0; j<i; j++) {
                // 找到前面那些结尾比 nums[i] 小的子序列
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = 0;
        for (int i=0; i<dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
    }
}
