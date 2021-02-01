package com.claus.sort;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_252_Meeting_Rooms {
    public static boolean canAttendMeetings(int[][] intervals) {
        // 将区间排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 遍历区间，比较前一个区间的第二个值是否比后一个区间的第一个值大
        for (int i=1; i < intervals.length; i++) {
            if (intervals[i-1][1] > intervals[i][0]) {
                return false; // 有重叠
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{7,10},{2,4},{15,20}};
        boolean res = canAttendMeetings(intervals);
    }
}
