package com.claus.SlideWindow.atMostK;

import java.util.HashMap;
import java.util.Map;

public class leetcode_340_Longest_Substring_with_At_Most_K_Distinct_Characters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            char rc = s.charAt(i);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            while (map.size() > k) {
                char lc = s.charAt(left++);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0) map.remove(lc);
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
