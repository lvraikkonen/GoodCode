package com.claus.SlideWindow;

public class leetcode_209_Minimum_Size_Subarray_Sum {

    public static int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0; // 窗口中数值总和
        int i = 0; // 滑动窗口起始位置
        int subLength = 0; // 滑动窗口长度
        for (int j=0; j < nums.length; j++) {
            sum += nums[j];

            // 超过s，开始移动滑动窗口起始位置
            while (sum >= s) {
                subLength = (j - i + 1);
                result = result < subLength ? result : subLength;
                sum -= nums[i];
                i += 1;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        int res = minSubArrayLen(s, nums);
    }
}
