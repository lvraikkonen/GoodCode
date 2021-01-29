package com.claus.binarySearch;

public class leetcode_33_Search_in_Rotated_Sorted_Array {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) { // 左区间连续递增
                if (nums[low]<=target && target<nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // mid后面区间连续递增
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int idx = search(nums, 0);
    }
}
