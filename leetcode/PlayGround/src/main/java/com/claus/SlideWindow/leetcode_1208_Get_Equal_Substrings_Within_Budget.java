package com.claus.SlideWindow;

public class leetcode_1208_Get_Equal_Substrings_Within_Budget {

    public static int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0;
        int[] costs = new int[s.length()];
        for (int i=0; i < s.length(); i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int max_len = 0;
        int sums = 0;
        while (right < s.length()) {
            sums += costs[right];
            while (sums > maxCost) {
                // 窗口不符合条件
                sums -= costs[left];
                left += 1;
            }
            max_len = Math.max(max_len, right-left+1);
            right += 1;
        }
        return max_len;
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcdf";
        int res = equalSubstring(s1, s2, 3);
    }
}
