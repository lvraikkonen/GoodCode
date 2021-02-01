package com.claus.sort;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_56_Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        // 将区间排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] res = new int[intervals.length][2];
        int idx = -1;

        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，说明不重叠
            if (idx==-1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 重叠，将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx+1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);
    }
}
