package com.claus.SlideWindow;

import java.util.ArrayList;

public class leetcode_395_Longest_Substring_with_At_Least_K_Repeating_Characters {

    /*
    每一字符出现次数都不少于 k
     */
    public static int longestSubstring(String s, int k) {
        int n = s.length();
        char[] ch_arr = s.toCharArray();
        int res = 0;

        // 每次循环中，滑动窗口内只有i个不同字符
        for (int i=1; i<=26; i++) {
            int left=0, right=0;
            int[] cnt = new int[26];
            int diff_count = 0; // 窗口内不同字符数
            int count = 0;      // 窗口内大于等于k的字符数
            while (right < n) {
                cnt[ch_arr[right] - 'a']++;
                // 第一次统计该字符个数
                if (cnt[ch_arr[right] - 'a'] == 1) {
                    diff_count += 1;
                }
                // 字符出现次数等于k
                if (cnt[ch_arr[right] - 'a'] == k) {
                    count += 1;
                }

                right ++;

                while (left<right && diff_count>i) {
                    // 窗口中不同字符个数超过i，窗口左端点右移
                    if (cnt[ch_arr[left]-'a'] == k) {
                        count -= 1;
                    }
                    if (cnt[ch_arr[left]-'a'] == 1) {
                        diff_count -= 1;
                    }
                    cnt[ch_arr[left]-'a'] --;
                    left += 1;
                }
                // 窗口内出现i个不同字符并且每个字符都大于等于k
                if (diff_count==i && diff_count==count) {
                    res = Math.max(res, right-left);
                }
            }
        }
        return res;
    }

    public static int longestSubstring_1(String s, int k) {
        int[] count = new int[26];
        for (char ch: s.toCharArray()) {
            count[ch-'a'] ++;
        }
        // 存放每个分割点的索引
        ArrayList<Integer> split = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if (count[s.charAt(i)-'a'] < k) {
                // i位置的字符不满足条件，将该字符加入split
                split.add(i);
            }
        }
        if (split.isEmpty()) {
            return s.length();
        }
        int res = 0, pre = 0;
        split.add(s.length());
        for (Integer i: split) {
            res = i > pre ? Math.max(res, longestSubstring_1(s.substring(pre, i),k)) : res;
            pre = i+1;
        }
        return res;
    }

    public static int longestSubstring_2(String s, int k) {
        if (s==null || s.length()==0) {
            return 0;
        }
        int[] count = new int[26];
        for (char ch: s.toCharArray()) {
            count[ch-'a']++;
        }

        // 是否整个字符串都符合
        boolean fullString = true;

        StringBuilder cut = new StringBuilder();
        cut.append("[");
        for (int i=0; i < 26; i++) {
            if (count[i] >0 && count[i] < k) {
                fullString = false;
                cut.append("//");
                cut.append((char)(i + 'a'));
            }
        }
        if (fullString) {
            return s.length();
        }
        cut.append("]");
        String[] cuted = s.split(cut.toString());

        int res = 0;
        for (String c: cuted) {
            // 递归
            res = Math.max(res, longestSubstring_2(c, k));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababacb";
        int res = longestSubstring_2(s, 3);
    }
}
