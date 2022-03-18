package com.claus.math;

public class leetcode_9_Palindrome_Number {

    public boolean isPalindrome(int x) {
        // 判断翻转后是否与原数据一致
        if (x < 0) return false;
        int cur = 0;
        int num = x;
        while (num != 0) { // 从个位向高位拼接数字
            cur = cur * 10 + num%10;
            num /= 10;
        }
        return cur == x;
    }

    public static void main(String[] args) {
        int x = 101;
        leetcode_9_Palindrome_Number s = new leetcode_9_Palindrome_Number();
        boolean res = s.isPalindrome(x);
    }
}
