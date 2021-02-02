package com.claus.SlideWindow;

public class leetcode_485_Max_Consecutive_Ones {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int maxn = 0;
        while (right < len) {
            if (nums[right] == 0) {
                // 不符合窗口条件
                maxn = Math.max(maxn, right-left);
                left = right + 1;
            }
            right += 1;
        }
        // 最后一个窗口
        maxn = Math.max(maxn, right-left);
        return maxn;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int result = findMaxConsecutiveOnes(nums);
    }
}
