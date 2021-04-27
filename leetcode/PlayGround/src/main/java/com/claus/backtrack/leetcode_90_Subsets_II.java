package com.claus.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_90_Subsets_II {

    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, track);
        return res;
    }

    static void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int i=start; i < nums.length; i++) {
            // 去重
            if (i>start && nums[i-1]==nums[i]) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i+1, track);
            // 撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(nums);
    }
}
