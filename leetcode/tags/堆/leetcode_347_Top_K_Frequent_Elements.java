package com.claus.heap;

import java.util.*;

public class leetcode_347_Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        final HashMap<Integer, Integer> num_freq = new HashMap<>();
        for (int num: nums) {
            if (num_freq.containsKey(num)) {
                num_freq.put(num, num_freq.get(num)+1);
            } else {
                num_freq.put(num, 1);
            }
        }
        // 遍历频率对，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return num_freq.get(o1) - num_freq.get(o2);
            }
        });
        for (Integer key: num_freq.keySet()) {
           if (pq.size() < k) {
               pq.add(key);
           } else if (num_freq.get(key) > num_freq.get(pq.peek())) {
               pq.remove();
               pq.add(key);
           }
        }

        // 取出最小堆中的元素
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.remove());
        }
        return ans;
    }

}
