package com.claus.array;

public class leetcode_1128_Number_of_Equivalent_Domino_Pairs {

    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] nums = new int[100];
        int res = 0;
        for (int[] domino: dominoes) {
            int val = domino[0] < domino[1] ? domino[0]*10+domino[1] : domino[1]*10+domino[0];
            res += nums[val];
            nums[val] ++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] doms = {{1,2},{2,1},{3,4},{5,6}};
        int result = numEquivDominoPairs(doms);
    }
}
