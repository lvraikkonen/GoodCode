package com.claus.hash;

import java.util.HashSet;
import java.util.Set;

public class leetcode_1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique {

    public static int minDeletions(String s) {
        int[] char_freq = new int[26];
        char[] char_arr = s.toCharArray();
        for (char ch: char_arr) {
            // 统计字符次数
            char_freq[ch - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int freq: char_freq) {
            if (freq != 0) {
                while (set.contains(freq)) {
                    // 加进来的数目已经存在，就自减, 减到没有的次数
                    freq -= 1;
                    res += 1;
                }
                if (freq != 0) {
                    set.add(freq);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ceabaacb";
        int res = minDeletions(s);
    }
}
