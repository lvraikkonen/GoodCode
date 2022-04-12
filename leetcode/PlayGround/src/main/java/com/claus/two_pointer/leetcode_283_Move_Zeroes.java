package com.claus.two_pointer;

public class leetcode_283_Move_Zeroes {

    public static void moveZeros(int[] nums) {
        if (nums==null) {
            return;
        }
        int j=0;
        for (int i=0; i<nums.length; i++) {
            // 当前元素不等于0，就将其交换到左边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }

    public static void moveZeros_1(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        // slowIndex后的全部置成0
        for (int i = slowIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeros_2(int[] nums) {
        int slow = 0;
        for (int fast=0; fast < nums.length; fast++) {
            if (nums[fast]!=0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int j = slow; slow < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,0,7};
        moveZeros_2(nums);
    }
}
