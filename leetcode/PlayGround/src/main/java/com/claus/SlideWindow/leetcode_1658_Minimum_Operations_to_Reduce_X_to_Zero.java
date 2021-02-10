package com.claus.SlideWindow;

import java.util.Arrays;

public class leetcode_1658_Minimum_Operations_to_Reduce_X_to_Zero {
    /*
    给你一个整数数组 nums 和一个整数 x 。
    每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。

    如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。

    滑动窗口找中间最长的窗口使得sum(窗口)=sum(nums)-x
     */
    public static int minOperations(int[] nums, int x) {
        int max_len = -1;
        int target_sum = Arrays.stream(nums).sum() - x;
        int current_sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            current_sum += nums[right];
            right += 1;
            while (current_sum > target_sum && left < nums.length) {
                // 窗口不符合条件，左端前移
                current_sum -= nums[left];
                left += 1;
            }
            if (current_sum == target_sum) {
                max_len = Math.max(max_len, right-left);
            }
        }
        if (max_len==-1) {
            return -1;
        }
        return nums.length-max_len;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,20,1,1,3};
        int x = 10;
        int res = minOperations(nums, x);
    }
}
