package com.claus.backtrack;

import java.util.LinkedList;
import java.util.List;

public class leetcode_77_combine {

    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        if (k<=0 || n<=0) {
            return res;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, 1, track);
        return res;

    }

    private static void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        // 结束条件
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i=start; i<=n; i++) {
            // 做选择
            track.add(i);
            backtrack(n, k, i+1, track);

            // 撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
    }
}
