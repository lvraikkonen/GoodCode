package com.claus.heap;


import java.util.PriorityQueue;

// 703. Kth Largest Element in a Stream

/*
小顶堆实现原理：

第k大的数就是数组按照从大到小的顺序下的第k位
利用小顶堆的特性，堆只保留k个元素，第1大到第k大的数都在堆里，第k大的数正好是堆顶
如果要插入的数比堆顶元素大，堆顶元素就变为了第k+1大的数，应该从堆中舍弃，于是就将堆顶元素替换为新元素，再调整堆使其满足小顶堆的特性，此时堆顶依然是第k大的数

1 最小堆的特性就是最小的值在最上面，每次取O(1)，插入O(n)
2 初始化的时候，注意如何添加元素，并给队列一个合适大小的初值
3 每次添加元素，能添加到队列的有两种情况，一种未到k个，另一种比堆顶大
 */
public class KthLargest {

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

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
