package com.claus.String;

public class leetcode_859_Buddy_Strings {

    public boolean buddyStrings(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if (m != n) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int diffCnt = 0;
        for (int i=0; i < m; i++) {
            int a = s.charAt(i) - 'a';
            int b = goal.charAt(i) - 'a';
            cnt1[a] ++;
            cnt2[b] ++;
            if (a != b) diffCnt++;
        }

        boolean ans = false;
        for (int i=0; i<26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
            if (cnt1[i] > 1) ans = true;
        }
        return diffCnt==2 || (diffCnt==0 && ans);
    }

    public static void main(String[] args) {
        String s = "aa";
        String goal = "aa";
        leetcode_859_Buddy_Strings solution = new leetcode_859_Buddy_Strings();
        boolean res = solution.buddyStrings(s, goal);
    }
}
