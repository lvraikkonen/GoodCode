package com.claus.binarySearch;

public class leetcode_81_Search_in_Rotated_Sorted_Array_II {

    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // 处理重复数字
            while (low < high && nums[low]==nums[low+1]){
                low += 1;
            }
            while (low < high && nums[high]==nums[high-1]) {
                high -= 1;
            }
            int mid = low + ((high-low)>>1);
            if (nums[mid]==target) {
                return true;
            }
            // 左区间连续递增
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // 右区间单调递增
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        boolean res = search(nums, 3);
    }
}
