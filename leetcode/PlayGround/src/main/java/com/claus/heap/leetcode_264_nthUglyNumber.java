package com.claus.heap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class leetcode_264_nthUglyNumber {
    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        heap.add(1L);

        HashSet<Long> seen = new HashSet();
        seen.add(1L);

        int[] factors = new int[]{2, 3, 5};

        Long currUgly = 1L, newUgly;

        for (int i = 0; i < n; ++i) {
            currUgly = heap.poll();
            for(int f: factors) {
                newUgly = currUgly * f;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
        return (int)currUgly.longValue();
    }

    public static void main(String[] args) {
        int result = nthUglyNumber(15);
        System.out.println(result);
    }
}
