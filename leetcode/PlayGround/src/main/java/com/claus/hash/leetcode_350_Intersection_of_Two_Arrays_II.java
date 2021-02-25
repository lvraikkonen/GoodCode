package com.claus.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_350_Intersection_of_Two_Arrays_II {
    public static int[] intersact(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (int num: nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                // 将匹配数字出现次数-1
                map.put(num, map.get(num)-1);
            }
        }
        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] res = intersact(num1, num2);
    }
}
