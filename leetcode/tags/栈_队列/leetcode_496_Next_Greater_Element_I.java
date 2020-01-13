package stack;

import java.util.HashMap;
import java.util.Stack;

public class leetcode_496_Next_Greater_Element_I {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
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
}
