package com.claus.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_78_subset {

    static List<List<Integer>> res = new LinkedList<>();

    static List<List<Integer>> subset(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    static void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i+1, track);
            // 撤销选择
            track.removeLast();
        }
    }


    public List<List<Integer>> subsets_1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subset(nums);
    }
}
