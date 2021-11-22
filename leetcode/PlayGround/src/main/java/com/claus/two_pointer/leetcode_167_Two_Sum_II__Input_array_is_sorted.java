package com.claus.two_pointer;

public class leetcode_167_Two_Sum_II__Input_array_is_sorted {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers==null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i+1, j+1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        leetcode_167_Two_Sum_II__Input_array_is_sorted solution = new leetcode_167_Two_Sum_II__Input_array_is_sorted();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = solution.twoSum(nums, target);
    }
}
