package com.claus.backtrack;

import java.util.LinkedList;
import java.util.List;

public class leetcode_45_permute {

    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /*
    track: 选择路径
    nums： 选择列表
    结束条件： nums中的元素全都在track中出现
     */
    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
    }
}
