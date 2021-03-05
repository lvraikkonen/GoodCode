package com.claus.DP;

// 303. Range Sum Query - Immutable
// https://leetcode-cn.com/problems/range-sum-query-immutable/
public class NumArray_303 {
    // 前缀和
    private int[] sums;

    public NumArray_303(int[] nums) {
        sums = new int[nums.length];
        if (nums.length == 0) {
            return;
        }
        sums[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            sums[i] += sums[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i==0) {
            return sums[j];
        } else {
            return sums[j] - sums[i-1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray_303 na = new NumArray_303(nums);
        int res1 = na.sumRange(0, 2);
        int res2 = na.sumRange(0, 2);

    }
}
