package com.claus.SlideWindow.atMostK;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1358_Number_of_Substrings_Containing_All_Three_Characters {
    public static int numberOfSubstrings(String s) {
        return atMostK(s, 3) - atMostK(s, 2);
    }

    private static int atMostK(String s, int K) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        int n = s.length();
        for (int i=0; i<n; i++) {
            char ch_right = s.charAt(i);
            map.put(ch_right, map.getOrDefault(ch_right, 0) + 1);

            while (map.size() > K) {
                char ch_left = s.charAt(left);
                map.put(ch_left, map.get(ch_left) - 1);
                if (map.get(ch_left)==0) {
                    map.remove(ch_left);
                }
                left += 1;
            }
            count += i - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        int result = numberOfSubstrings(s);
    }
}
