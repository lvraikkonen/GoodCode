package com.claus.two_pointer;

public class leetcode_80_Remove_Duplicates_from_Sorted_Array_II {

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int j = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[j] = nums[i]; // 覆盖
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
}
