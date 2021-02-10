package com.claus.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_15_3Sum {

    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for (int k=0; k<nums.length-2; k++) {
            if (nums[k] > 0) break;
            if (k>0 && nums[k]==nums[k-1]) continue; // skip duplicate items
            int i = k+1;
            int j = nums.length-1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    // skip duplicates
                    while (i<j && nums[i]==nums[++i]);
                } else if (sum > 0) {
                    // skip duplicates
                    while (i<j && nums[j]==nums[--j]);
                }
                else {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    // skip same result
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i< nums.length-2; i++) {
            if (i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            int target = - nums[i];

            while (left < right) {
                if (nums[left]+ nums[right] == target) {
                    res.add(Arrays.asList(nums[left], nums[i], nums[right]));
                    left++;
                    right--;
                    while (left<right && nums[left]==nums[left-1]) {
                        left++; // 去重
                    }
                    while (left<right && nums[right]==nums[right+1]) {
                        right--; // 去重
                    }
                }
                else if (nums[left]+nums[right] > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = threeSum1(nums);
    }
}
