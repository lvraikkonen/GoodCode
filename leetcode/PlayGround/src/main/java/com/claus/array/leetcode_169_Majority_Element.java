package com.claus.array;

import java.util.HashMap;
import java.util.Map;

public class leetcode_169_Majority_Element {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int length = nums.length;
        for (int i=0; i<length; i++) {
            int count = counts.getOrDefault(nums[i], 0) + 1;
            // 超n/2直接返回
            if (count > length/2) {
                return nums[i];
            }
            counts.put(nums[i], count);
        }
        return -1;
    }

    /*
    摩尔投票法：拼消耗，不同的抵消
     */
    public static int majorityElement_1(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                //前面都消完了，在重新赋值
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                //自己人，count就加1
                count++;
            } else {
                //不是自己人就同归于尽，消掉一个
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int res = majorityElement_1(nums);
    }
}
