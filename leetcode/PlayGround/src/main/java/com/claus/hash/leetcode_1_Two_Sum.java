package com.claus.hash;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        leetcode_1_Two_Sum solution = new leetcode_1_Two_Sum();
        int[] res = solution.twoSum(nums, target);
    }
}
