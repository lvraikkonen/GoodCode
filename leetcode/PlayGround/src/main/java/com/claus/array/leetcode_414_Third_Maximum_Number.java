package com.claus.array;

public class leetcode_414_Third_Maximum_Number {
    public static int thirdMax(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        if (nums.length==2) {
            // 返回最大的
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int num: nums) {
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num == firstMax) {
                continue;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num == secondMax) {
                continue;
            } else if (num > thirdMax) {
                thirdMax = num;
            }
        }
        if (thirdMax == Long.MIN_VALUE) {
            return (int)firstMax;
        } else {
            return (int)thirdMax;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        int res = thirdMax(nums);
    }
}
