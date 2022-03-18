package com.claus.heap;

import java.util.PriorityQueue;

public class leetcode_1005_Maximize_Sum_Of_Array_After_K_Negations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.add(num);
        }
        while (k>0) {
            int current_min = pq.poll();
            pq.add(-current_min);
            k--;
        }
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,-1,0,2};
        leetcode_1005_Maximize_Sum_Of_Array_After_K_Negations s = new leetcode_1005_Maximize_Sum_Of_Array_After_K_Negations();
        int res = s.largestSumAfterKNegations(nums, 3);
    }
}
