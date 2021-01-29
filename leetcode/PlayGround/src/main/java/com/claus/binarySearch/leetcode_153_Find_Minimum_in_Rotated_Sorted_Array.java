package com.claus.binarySearch;

public class leetcode_153_Find_Minimum_in_Rotated_Sorted_Array {

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                // 单调递增，最小值为第一个元素
                return nums[low];
            }
            int mid = low + ((high-low)>>1);
            // mid 左侧单调递增，说明最小值一定不在这一侧
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else if (nums[low] > nums[mid]) {
                // 最小值在low与mid之间
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        int res = findMin(nums);
    }
}
