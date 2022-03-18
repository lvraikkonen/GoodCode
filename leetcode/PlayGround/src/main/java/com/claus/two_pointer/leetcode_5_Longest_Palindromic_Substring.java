package com.claus.two_pointer;

public class leetcode_5_Longest_Palindromic_Substring {

    public static String longestPalindrome(String s) {
        String res = "";
        for (int i=0; i<s.length()-1; i++) {
            // 奇数个字符，中间字符是一个，以i为中心
            String res1 = palindrome(s, i, i);
            // 偶数个字符，中间字符是两个，以i和i+1为中心
            String res2 = palindrome(s, i, i+1);
            res = res.length()>res1.length() ? res : res1;
            res = res.length()>res2.length() ? res : res2;
        }
        return res;
    }

    private static String palindrome(String s, int l, int r) {
        // 从中间向两边扩散判断
        int len = s.length();
        int i = l;
        int j = r;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);

    }

    public static void main(String[] args) {
        String s = "cbbcd";
        String result = longestPalindrome(s);
    }
}
