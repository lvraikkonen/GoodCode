package com.claus.SlideWindow;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode_209_SlidingWindowMaxValue {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        int[] res = new int[len - k + 1];
        int arr_idx = 0;
        // 维护一个单调递增的双向队列
        Deque<Integer> deque = new LinkedList<>();
        // 将第一个窗口的值按照规则入队
        for (int i=0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast(); // 队尾元素小于要加入的元素，则将队尾元素出队，直到队尾元素大于新元素时，再让新元素入队
            }
            deque.offerLast(nums[i]);
        }
        // 将第一个窗口最大值存入结果
        res[arr_idx++] = deque.peekFirst();
        // 移动窗口
        for (int j = k; j < len; j++) {
            // 窗口的前一个元素等于队头元素（窗口向前移动去掉了最大值）
            if (nums[j - k] == deque.peekFirst()) {
                deque.removeFirst(); // 队头出队
            }
            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.offerLast(nums[j]);
            res[arr_idx++] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow(nums, 3);
    }
}
