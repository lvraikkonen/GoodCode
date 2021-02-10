package com.claus.SlideWindow;

import java.util.Arrays;

public class leetcode_567_Permutation_in_String {

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        Arrays.fill(s1Count, 0);
        Arrays.fill(windowCount, 0);
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int lo = 0, hi = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        int matched = 0;
        while (hi < len2) {
            char c1 = s2.charAt(hi);
            windowCount[c1 - 'a']++;
            if (windowCount[c1 - 'a'] <= s1Count[c1 - 'a']) {
                matched++;
            }
            if (hi - lo + 1 > len1) {
                char c2 = s2.charAt(lo);
                windowCount[c2 - 'a']--;
                if (s1Count[c2 - 'a'] > 0 && windowCount[c2 - 'a'] < s1Count[c2 - 'a']) {
                    matched--;
                }
                lo++;
            }
            if (matched == s1.length()) {
                return true;
            }
            hi++;
        }
        return false;

    }

    public static void main(String[] args) {
        boolean result = checkInclusion("ab", "eidbaooo");

    }
}
