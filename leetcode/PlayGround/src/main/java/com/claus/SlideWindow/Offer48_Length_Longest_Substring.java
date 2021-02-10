package com.claus.SlideWindow;

import java.util.HashMap;

public class Offer48_Length_Longest_Substring {
    // 无重复字符的最长子串
    // 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
    // 滑动窗口

    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) {
            return 0;
        }
        int left = 0, right = 0;
        int max_len = 0;
        // hashmap保存字符在字符串中出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // 字符出现过, 左侧窗口右移
                left = Math.max(left, map.get(c)+1);
            }
            max_len = Math.max(max_len, right-left+1);
            map.put(c, right);
            right += 1;
        }
        return max_len;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int res = lengthOfLongestSubstring(s);
    }
}
