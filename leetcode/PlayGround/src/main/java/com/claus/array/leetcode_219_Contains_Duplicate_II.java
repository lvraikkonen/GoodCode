package com.claus.array;

import java.util.HashSet;

public class leetcode_219_Contains_Duplicate_II {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // 哈希表，里面始终最多包含 k 个元素
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        boolean res = containsNearbyDuplicate(nums, 2);
    }
}
