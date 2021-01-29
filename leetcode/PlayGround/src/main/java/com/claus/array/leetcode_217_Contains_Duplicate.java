package com.claus.array;

import java.util.*;

public class leetcode_217_Contains_Duplicate {

    public static boolean containsDuplicate_1(int[] nums) {
        // HashMap
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i: nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        for (int i: nums) {
            if (hashMap.get(i) >= 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate_2(int[] nums) {
        // HashSet 不存储重复数字，如有重复返回true
        Set<Integer> hashSet = new HashSet<>();
        for (int i: nums) {
            if (!hashSet.add(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate_3(int[] nums) {
        // 排序+遍历
        Arrays.sort(nums);
        for (int i=0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean result = containsDuplicate_1(nums);
    }
}
