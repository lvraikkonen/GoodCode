package com.claus.two_pointer;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode_3_Longest_Substring_Without_Repeating_Characters {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length()==0) {
            return 0;
        }
        int left =0;
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            ans = Math.max(ans, i-left+1);
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
