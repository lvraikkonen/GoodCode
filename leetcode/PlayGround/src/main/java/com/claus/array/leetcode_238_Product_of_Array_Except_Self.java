package com.claus.array;

public class leetcode_238_Product_of_Array_Except_Self {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i=0; i<nums.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int i = res.length-1; i>=0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] res = productExceptSelf(nums);
    }
}
