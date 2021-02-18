package com.claus.array;

import java.util.LinkedList;
import java.util.List;

public class leetcode_448_Find_All_Numbers_Disappeared_in_an_Array {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int index=Math.abs(nums[i]) - 1;
            nums[index] = -1 * Math.abs(nums[index]);
        }
        List<Integer> result = new LinkedList<>();
        for (int i=0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = findDisappearedNumbers(nums);
    }
}
