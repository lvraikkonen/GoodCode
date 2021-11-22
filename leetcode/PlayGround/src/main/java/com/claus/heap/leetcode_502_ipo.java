package com.claus.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode_502_ipo {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];

        for (int i=0; i < n; i++) {
            arr[i][0] = capital[i]; // 所需资本
            arr[i][1] = profits[i]; // 产生净利润
        }

        // 项目按照所需资本的从小到大进行排序
        Arrays.sort(arr, (a, b) -> a[0]-b[0]);

        // 构造大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i=0; i < k; i++) {
            while (curr < n && arr[curr][0] <= w) {
                // 从所有投入资本小于等于 w 的项目中选择利润最大的项目
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                // 穷
                break;
            }
        }
        return w;
    }


    public static void main(String[] args) {
        leetcode_502_ipo solution = new leetcode_502_ipo();
        int res = solution.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
    }
}
