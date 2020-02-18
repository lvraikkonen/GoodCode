package com.claus.heap;

import java.util.*;

public class leetcode_692_Top_K_Frequent_Words {

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1).equals(map.get(s2))) {
                    return s2.compareTo(s1);
                }
                return map.get(s1).compareTo(map.get(s2));
            }
        });

        for (String key: map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (queue.comparator().compare(key, queue.peek()) > 0) {
                queue.poll();
                queue.add(key);
            }
        }

        String[] res = new String[k];

        for (int i = k-1; i>=0; i--) {
            res[i] = queue.poll();
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) throws Exception {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words, 2));
    }
}
