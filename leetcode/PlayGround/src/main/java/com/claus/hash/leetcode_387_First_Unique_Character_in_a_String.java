package com.claus.hash;

import java.util.HashMap;
import java.util.Map;

public class leetcode_387_First_Unique_Character_in_a_String {

    public static int findUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }
        for (int i=0; i < s.length(); i++) {
            if (freq.get(s.charAt(i))==1) {
                // 只出现一次
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int idx = findUniqChar(s);
    }
}
