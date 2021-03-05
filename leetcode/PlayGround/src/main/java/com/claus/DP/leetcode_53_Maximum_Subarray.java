package com.claus.DP;

public class leetcode_53_Maximum_Subarray {
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxSum = nums[0];
        for (int num: nums) {
            pre = Math.max(pre+num, num);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
    }
}
