package com.claus.two_pointer;

public class leetcode_424_Longest_Repeating_Character_Replacement {
    /*
    如果当前字符串中的出现次数最多的字母个数 +K+K 大于串长度，那么这个串就是满足条件的

    维护一个数组 int[26] 来存储当前窗口中各个字母的出现次数，
    leftleft 表示窗口的左边界，rightright 表示窗口右边界

    窗口扩张：leftleft 不变，right++right++
    窗口滑动：left++left++，right++right++
    historyCharMaxhistoryCharMax 保存滑动窗口内相同字母出现次数的 历史 最大值，
    通过判断窗口宽度 (right - left + 1)是否大于 historyCharMax + K
    来决定窗口是否做滑动，否则窗口就扩张
     */
    public static int characterReplacement(String s, int k) {
        int[] nums = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            /*
            该区间内除了出现次数最多的那一类字符之外
            剩余的字符（即非最长重复字符）数量不超过 k 个
             */
            nums[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, nums[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                nums[s.charAt(left) - 'A']--;
                left++; // 窗口向前滑动
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        int result = characterReplacement("AABABBA", 1);
    }
}
