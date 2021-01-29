package com.claus.sort;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_179_largerNumber {
    public static String largerNumber(int[] nums) {
        // 将输入数组装换为字符串数组
        String[] strs = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 自定义排序，将更大的放在前面
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1);
            }
        });

        // 0
        if (strs[0].equals("0")) {
            return "0";
        }
        String res = new String();
        for (String s: strs) {
            res += s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String result = largerNumber(nums);
    }
}
