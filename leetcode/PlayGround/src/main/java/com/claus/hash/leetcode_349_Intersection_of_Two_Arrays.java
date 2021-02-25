package com.claus.hash;

import java.util.HashSet;
import java.util.Set;

public class leetcode_349_Intersection_of_Two_Arrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null || nums1.length==0 || nums2.length==0) {
            return new int[0];
        }
        Set<Integer> parentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        for (int num: nums1) {
            parentSet.add(num);
        }
        for (int num: nums2) {
            if (parentSet.contains(num)) {
                childSet.add(num);
            }
        }
        int[] res = new int[childSet.size()];
        int idx = 0;
        for (int num: childSet) {
            res[idx] = num;
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] res = intersection(num1, num2);
    }
}
