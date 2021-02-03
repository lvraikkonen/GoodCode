package com.claus.Design;

import java.util.PriorityQueue;

public class KthLargest {
    // 703. Kth Largest Element in a Stream
    private PriorityQueue<Integer> queue;
    private int limit;

    public KthLargest(int k, int[] nums) {
        limit = k;
        queue = new PriorityQueue<>(k);
        for (int num: nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < limit){
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}
