package com.claus.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_506_Relative_Ranks {
    String[] mapping = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        int[] clone = score.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=n-1; i>=0; i--) {
            map.put(clone[i], n-1-i);
        }
        for (int i=0; i<n; i++) {
            int rank = map.get(score[i]);
            ans[i] = rank < 3 ? mapping[rank] : String.valueOf(rank + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] scores = {10, 3, 8, 9, 4};
        leetcode_506_Relative_Ranks solution = new leetcode_506_Relative_Ranks();
        String[] res = solution.findRelativeRanks(scores);
    }
}
