package com.claus.two_pointer;

import java.util.ArrayList;
import java.util.List;

public class leetcode_228_Summary_Ranges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        for (int j=0; j < nums.length; j++) {
            if (j+1==nums.length || nums[j+1]!=nums[j]+1) { // 到头或者不连续
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if (i != j) {
                    sb.append("->").append(nums[j]);
                }
                res.add(sb.toString());
                i = j + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,7};
        List<String> result = summaryRanges(nums);
    }
}
