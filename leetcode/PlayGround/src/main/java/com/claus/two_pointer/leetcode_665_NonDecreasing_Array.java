package com.claus.two_pointer;

public class leetcode_665_NonDecreasing_Array {

    public static boolean checkPossibility(int[] nums) {
        if (nums.length==0) {
            return false;
        }
        if (nums.length <= 2) {
            return true;
        }
        int low=0, high = nums.length-1;
        while (low < high && nums[low] <= nums[low+1]) {
            low++;
        }
        while (low < high && nums[high-1] <= nums[high]) {
            high--;
        }
        if (high-low > 1) {
            return false;
        }
        if (low==0 || high==nums.length-1
                   || nums[low-1] <= nums[low+1]
                   || nums[high-1] <= nums[high+1]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,1};
        boolean flag = checkPossibility(nums);
    }
}
