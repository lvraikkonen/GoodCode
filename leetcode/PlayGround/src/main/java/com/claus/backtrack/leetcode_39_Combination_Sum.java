package com.claus.backtrack;

import java.util.*;

public class leetcode_39_Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        // 排序
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target,path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=begin; i<len; i++) {
            if (target - candidates[i] < 0 ) {
                // 剪枝
                break;
            }
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + " , 剩余 = " + (target - candidates[i]));

            // 递归
            dfs(candidates, i, len, target-candidates[i], path, res);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        leetcode_39_Combination_Sum solution = new leetcode_39_Combination_Sum();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println("输出 => " + res);
    }
}
