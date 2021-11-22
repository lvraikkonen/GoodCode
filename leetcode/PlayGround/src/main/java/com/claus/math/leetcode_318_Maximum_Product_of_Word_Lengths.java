package com.claus.math;

public class leetcode_318_Maximum_Product_of_Word_Lengths {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] nums = new int[n];

        // 先将每个单词转换为一个32位数字
        for (int i = 0; i < n; i++) {
            nums[i] = convert(words[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                // 两个单词中字母都不相同
                if ((nums[i] & nums[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    /*
    将字符串转换，用一个3232位二进制的数字表示
    二进制位第[0,25]位，分别对应[a,z],每一位的状态为0或1，0表不存在该字母，1表示存在该字母
     */
    private int convert(String word) {
        int ans = 0;
        for (int i=0; i < word.length(); i++) {
            ans |= 1 << (word.charAt(i) - 'a');
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        leetcode_318_Maximum_Product_of_Word_Lengths solution = new leetcode_318_Maximum_Product_of_Word_Lengths();
        int res = solution.maxProduct(words);
    }
}
