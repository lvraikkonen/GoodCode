package com.claus.String;

public class leetcode_14_Longest_Common_Prefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        // 初始化为第一个字符串
        String res = strs[0];
        for (int i=1; i<strs.length; i++) {
            int j=0;
            for (; j<res.length() && j<strs[i].length(); j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            if (res.equals("")) {
                return res;
            }
        }
        return res;
    }

    public static String longestCommonPrefix_1(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        // 初始化
        String res = strs[0];
        for (String str: strs) {
            while (!str.startsWith(res)) {
                if (res.length()==0) {
                    return "";
                }
                res = res.substring(0, res.length()-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String res = longestCommonPrefix_1(strs);
    }
}
