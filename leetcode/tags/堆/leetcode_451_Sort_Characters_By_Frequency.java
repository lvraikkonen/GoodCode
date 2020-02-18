package com.claus.heap;

import java.util.PriorityQueue;

public class leetcode_451_Sort_Characters_By_Frequency {

    public static String frequencySort(String s) {
        // 字母数组计数
        int[] latters = new int[256];
        for (char c: s.toCharArray()) {
            latters[c]++;
        }

        PriorityQueue<Latter> queue = new PriorityQueue<>();

        for (int i=0; i<latters.length; i++) {
            if (latters[i]!=0) {
                queue.add(new Latter((char) i, latters[i]));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()) {
            Latter latter = queue.poll();
            for (int i=0; i<latter.count; i++) {
                stringBuilder.append(latter.latter);
            }
        }

        return stringBuilder.toString();
    }

    public static class Latter implements Comparable<Latter>{

        public char latter = '0';
        public int count = 0;

        public Latter(char latter, int count) {
            this.latter = latter;
            this.count = count;
        }

        @Override
        public int compareTo(Latter o) {
            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws Exception {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }
}
