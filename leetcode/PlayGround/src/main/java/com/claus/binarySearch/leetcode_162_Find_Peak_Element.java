package com.claus.binarySearch;

public class leetcode_162_Find_Peak_Element {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        // 先特判两边情况
        if(nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n - 1;

        int l = 0, r = n - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;

            // 当前为峰值
            if(mid >= 1 && mid < n - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if(mid >= 1 && nums[mid] < nums[mid - 1]) {
                // 峰值在 mid 左侧
                r = mid - 1;
            } else if(mid < n - 1 && nums[mid] < nums[mid + 1]) {
                // 峰值在 mid 右侧
                l = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        leetcode_162_Find_Peak_Element s = new leetcode_162_Find_Peak_Element();
        int res = s.findPeakElement(nums);
    }
}
