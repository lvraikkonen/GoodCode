package com.claus.array;

import java.util.ArrayList;
import java.util.List;

public class leetcode_442_Find_All_Duplicates_in_an_Array {
    /*
    找到数字i时，将位置i-1处的数字翻转为负数。
    如果位置i-1 上的数字已经为负，则i是出现两次的数字
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                // 访问过
                res.add(Math.abs(index+1));
            }
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 7, 3, 1};
        List<Integer> res = findDuplicates(nums);
    }
}
