package com.claus.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // O(n^3)
        for (int i = 0; i < nums.length - 3; i++) {
            // 忽略后面与前面重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // 忽略后面与前面重复的元素
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int partSum = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = partSum + nums[left] + nums[right];

                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right) {
                            left++;
                            if (nums[left - 1] != nums[left]) break;
                        }
                        while (left < right) {
                            right--;
                            if (nums[right + 1] != nums[right]) break;
                        }
                    }
                }
            }
        }

        return res;
    }
}
