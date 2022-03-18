package com.claus.binarySearch;

public class leetcode_540_Single_Element_in_a_Sorted_Array {

    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            // mid 为偶数
            if (mid % 2 == 0) {
                // 当前和后一个进行对比
                if (mid+1<len && nums[mid] == nums[mid+1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            // mid 为奇数
            else {
                // 当前和前一个进行对比
                if (mid-1>=0 && nums[mid-1] == nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        leetcode_540_Single_Element_in_a_Sorted_Array s = new leetcode_540_Single_Element_in_a_Sorted_Array();
        int res = s.singleNonDuplicate(nums);
    }
}
