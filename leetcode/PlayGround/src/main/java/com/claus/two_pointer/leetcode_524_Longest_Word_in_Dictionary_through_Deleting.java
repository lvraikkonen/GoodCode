package com.claus.two_pointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode_524_Longest_Word_in_Dictionary_through_Deleting {

    public String findLongestWord(String s, List<String> dictionary) {
        // 对于字典，按照字符串长度排倒序，长度相同的，则按照字典序排升序
        Collections.sort(dictionary, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });

        int n = s.length();
        for (String ss : dictionary) {
            // 判断是否是子串
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) {
                    j++; // 匹配上
                }
                i++;
            }
            if (j == m) {
                return ss;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dict = Arrays.asList(new String[]{"ale", "apple", "plea", "monkey"});
        leetcode_524_Longest_Word_in_Dictionary_through_Deleting solution = new leetcode_524_Longest_Word_in_Dictionary_through_Deleting();
        String res = solution.findLongestWord(s, dict);
    }
}
