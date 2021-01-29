package com.claus.stack;

import java.util.HashMap;
import java.util.Stack;

public class leetcode_496_Next_Greater_Element_I {

    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];

        for (int i=0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        for (int i=0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static int[] nextGreaterElement_stack(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> res = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // 倒着往栈里放
        for (int i = nums2.length-1; i>=0; i--) {
            // 判定个子高矮
            while (!stack.empty() && stack.peek() <= nums2[i]) {
                // 后面的矮个去掉
                stack.pop();
            }
            //
            res.put(nums2[i], stack.empty() ? -1: stack.peek());
            stack.push(nums2[i]);
        }

        // 去res中找答案
        for (int i=0; i<nums1.length;i++) {
            ans[i] = res.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] result = {};
        result = nextGreaterElement_stack(nums1, nums2);
    }
}
