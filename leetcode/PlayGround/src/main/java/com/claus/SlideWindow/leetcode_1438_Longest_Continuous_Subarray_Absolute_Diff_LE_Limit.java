package com.claus.SlideWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_1438_Longest_Continuous_Subarray_Absolute_Diff_LE_Limit {
    /*
    求滑动窗口最大值和最小值的差值小于等于limit
    的最长子数组长度

    方法1: 用两个优先队列分别存储滑动窗口最大值和最小值
     */
    public static int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int maxn = 0;
        Queue<Integer> queueMin = new PriorityQueue<>();
        Queue<Integer> queueMax = new PriorityQueue<>(((o1, o2) -> o2-o1));
        while (right < nums.length) {
            int num = nums[right];
            queueMax.add(num);
            queueMin.add(num);
            if (queueMax.peek() - queueMin.peek() <= limit) {
                maxn = Math.max(maxn, right-left+1);
                right++;
                continue;
            }
            // 窗口不满足条件
            queueMax.remove((Integer) nums[left]);
            queueMin.remove((Integer) nums[left]);
            left++;
            right++;
        }

        return maxn;
    }

    /*
    方法2: 用两个单调队列存储滑动窗口值
    维护两个单调双端队列: 一个最大队（队首元素 peek() 为最大值）,一个最小队
     */
    public static int longestSubarray_1(int[] nums, int limit) {
        Deque<Integer> queueMax = new LinkedList<>();
        Deque<Integer> queueMin = new LinkedList<>();

        int maxn = 0;
        for (int left=0,right=0; right<nums.length; right++) {
            // 维护单调减队列 队头的元素为最大值
            while (!queueMax.isEmpty() && queueMax.peekLast() < nums[right]) {
                queueMax.pollLast();
            }
            queueMax.addLast(nums[right]);
            // 维护单调增队列 队头的元素为最小值
            while (!queueMin.isEmpty() && queueMin.peekLast() > nums[right]) {
                queueMin.pollLast();
            }
            queueMin.addLast(nums[right]);

            // 检测当前窗口是否满足条件
            while (!queueMax.isEmpty() && !queueMin.isEmpty() && (queueMax.peek() - queueMin.peek() > limit)) {
                // 滑动窗口左边界右移，队头出队
                if (nums[left] == queueMax.peek()) {
                    queueMax.pollFirst();
                }
                if (nums[left] == queueMin.peek()) {
                    queueMin.pollFirst();
                }
                left++;
            }
            maxn = Math.max(maxn, right-left+1);
        }
        return maxn;
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;
        int res = longestSubarray_1(nums, limit);
    }
}
