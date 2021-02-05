package com.claus.SlideWindow;

public class leetcode_643_Maximum_Average_Subarray_I {

    public static double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for (int i=0; i < k; i++) {
            sum += nums[i];
        }
        int max_sum = sum;
        for (int i=k; i < len; i++) {
            // 滑动窗口
            sum = sum - nums[i-k] + nums[i];
            max_sum = Math.max(max_sum, sum);
        }
        return max_sum * 1.0 / k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        double result = findMaxAverage(nums, 4);
    }
}
