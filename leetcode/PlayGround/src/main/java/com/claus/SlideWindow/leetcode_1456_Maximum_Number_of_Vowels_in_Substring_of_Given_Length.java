package com.claus.SlideWindow;

public class leetcode_1456_Maximum_Number_of_Vowels_in_Substring_of_Given_Length {
    public static int maxVowels(String s, int k) {
        int left=0, right=0, maxn = 0;
        int count=0;
        while (right < s.length()) {
            char ch_right = s.charAt(right);
            if (ch_right=='a' || ch_right=='e' || ch_right=='i' || ch_right=='o' || ch_right=='u') {
                count += 1;
            }
            if (right-left+1 == k) {
                // 到达窗口大小
                maxn = Math.max(maxn, count);
                // 去掉窗口左边缘数据
                char ch_left = s.charAt(left);
                if (ch_left=='a' || ch_left=='e' || ch_left=='i' || ch_left=='o' || ch_left=='u') {
                    count -= 1;
                }
                left += 1;
            }
            right += 1;
        }
        return maxn;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        int res = maxVowels(s, k);
    }
}
