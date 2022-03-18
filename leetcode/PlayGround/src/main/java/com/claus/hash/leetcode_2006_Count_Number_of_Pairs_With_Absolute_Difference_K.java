package com.claus.hash;

import java.util.HashMap;
import java.util.Map;

public class leetcode_2006_Count_Number_of_Pairs_With_Absolute_Difference_K {

    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num: nums) {
            if (map.containsKey(num - k)) {
                res += map.get(num - k);
            }
            if (map.containsKey(num + k)) {
                res += map.get(num + k);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,4};
        leetcode_2006_Count_Number_of_Pairs_With_Absolute_Difference_K s = new leetcode_2006_Count_Number_of_Pairs_With_Absolute_Difference_K();
        int res = s.countKDifference(nums, 2);
    }
}
