package com.claus.String;

public class leetcode_1221_Split_a_String_in_Balanced_Strings {
    public int balancedStringSplit(String s) {
        int res = 0;
        int num = 0;
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                num++;
            } else {
                num--;
            }
            if (num == 0) {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        leetcode_1221_Split_a_String_in_Balanced_Strings solution = new leetcode_1221_Split_a_String_in_Balanced_Strings();
        int result = solution.balancedStringSplit(s);
    }
}
