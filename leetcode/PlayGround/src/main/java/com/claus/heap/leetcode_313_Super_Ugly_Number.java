package com.claus.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class leetcode_313_Super_Ugly_Number {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        heap.add(1L);
        seen.add(1L);
        for (int i=0; i<n-1; i++) {
            long tmp = heap.poll();
            for (int factor: primes) {
                long new_num = tmp * factor;
                if (!seen.contains(new_num)) {
                    heap.add(new_num);
                    seen.add(new_num);
                }
            }
        }
        long res = heap.poll();
        return (int) res;
    }

    public static int nthSuperUglyNumber_1(int n, int[] primes) {
        if (n < 1) {
            return 0;
        }
        long[] res = new long[n];
        res[0] = 1;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i=1; i < res.length; i++) {
            for (long f: primes) {
                long num = res[i-1];
                treeSet.add(num * f);
            }
            res[i] = treeSet.first();
            treeSet.remove(treeSet.first());
        }
        return (int)res[n-1];
    }

    public static void main(String[] args) {
        int res = nthSuperUglyNumber_1(12, new int[]{2, 7, 13, 19});
    }
}
