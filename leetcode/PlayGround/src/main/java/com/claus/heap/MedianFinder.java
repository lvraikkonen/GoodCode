package com.claus.heap;

// leetcode_295_Find_Median_from_Data_Stream
// 数据流的中位数
// 创建一个大顶堆和一个小顶堆
// 假设数据流已经排好序了
// 数据流分为两部分：构成大顶堆的数组左侧部分，构成小顶堆的数组右侧部分
// 如果数组个数为奇数，则中位数为大顶堆最大值；
// 如果数组元素个数为偶数，则中位数为大顶堆最大值和小顶堆最小值的平均值

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    private int count;
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        maxheap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minheap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());
        // 如果两个堆合起来元素个数为奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((count % 2) != 0) {
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if ((count % 2) != 0) {
            return (double) maxheap.peek();
        } else {
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        }
    }


    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(5);
        m.addNum(4);
        m.addNum(6);
        m.addNum(1);
        m.addNum(2);
        m.addNum(7);
        double result = m.findMedian();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


