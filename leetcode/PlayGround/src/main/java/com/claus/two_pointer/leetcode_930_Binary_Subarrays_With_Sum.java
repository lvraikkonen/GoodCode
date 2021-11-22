package com.claus.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class leetcode_930_Binary_Subarrays_With_Sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // 前缀和
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            res += map.getOrDefault(sum - goal, 0);
        }
        return res;
    }

    public int numSubarraysWithSum_array(int[] nums, int goal) {
        int[] map = new int[nums.length + 1];
        int sum = 0;
        int res = 0;
        for (int num: nums) {
            map[sum] ++;
            sum += num;
            if (sum - goal >= 0) {
                res += map[sum - goal];
            }
        }
        return  res;
    }

    public int numSubarraysWithSum_window(int[] nums, int goal)
    {
        int n = nums.length;

        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int res = 0;

        while (right < n) {
            sum1 += nums[right];
            sum2 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            res += left2 - left1;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode_930_Binary_Subarrays_With_Sum solution = new leetcode_930_Binary_Subarrays_With_Sum();
        int[] nums = {1,0,1,0,1};
        int res = solution.numSubarraysWithSum_window(nums, 2);
    }
}
