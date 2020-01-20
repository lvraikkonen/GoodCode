package com.claus.two_pointer;


public class leetcode_209_Minimum_Size_Subarray_Sum {

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                min = Math.min(min, right-left);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) throws Exception {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = 0;
        result = minSubArrayLen(s, nums);
        System.out.println(result);
    }
}
