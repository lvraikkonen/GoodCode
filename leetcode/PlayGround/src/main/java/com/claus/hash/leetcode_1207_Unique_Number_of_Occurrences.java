package com.claus.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode_1207_Unique_Number_of_Occurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }

    public static boolean uniqueOccurrences_1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for (int count: map.values()) {
            if (!set.add(count)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        boolean res = uniqueOccurrences_1(arr);
    }
}
