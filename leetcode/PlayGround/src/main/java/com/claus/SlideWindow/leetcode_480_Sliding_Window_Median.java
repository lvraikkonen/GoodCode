package com.claus.SlideWindow;

import java.util.Arrays;

public class leetcode_480_Sliding_Window_Median {

    // 交换
    private static void swap(int[] window, int i, int j) {
        int tmp = window[i];
        window[i] = window[j];
        window[j] = tmp;
    }

    // 求有序数组的中位数
    private static double getMid(int[] window) {
        int len = window.length;
        if (len % 2 == 0) {
            // 偶数个元素
            return window[len/2] * 0.5 + window[len/2 -1] * 0.5;
        } else {
            return window[len/2];
        }
    }

    // 二分查找
    private static int search(int[] window, int target) {
        int left = 0;
        int right = window.length-1;
        while (left <= right) {
            int mid = left + ((right-left)>>1);
            if (window[mid] < target) {
                left = mid + 1;
            } else if (window[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int[] window = new int[k];
        // 初始化窗口
        for (int i=0; i < k; i++) {
            window[i] = nums[i];
        }
        // 初始化窗口排序
        Arrays.sort(window);
        res[0] = getMid(window);

        // 窗口滑动
        for (int i=0; i < nums.length-k; i++) {
            // 删除左侧的数
            int idx = search(window, nums[i]);
            // 将新进入窗口的数插入到被删除的位置
            window[idx] = nums[i+k];
            // 冒泡保持窗口有序
            while (idx < window.length-1 && window[idx] > window[idx+1]) {
                swap(window, idx, idx+1);
                idx++;
            }
            while (idx > 0 && window[idx] < window[idx-1]) {
                swap(window, idx, idx-1);
                idx--;
            }
            res[i+1] = getMid(window);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647};
        double[] result = medianSlidingWindow(nums, 2);
    }
}
