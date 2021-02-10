package com.claus.SlideWindow.atMostK;

import java.beans.IntrospectionException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leetcode_992_Subarrays_with_K_Different_Integers {

    public static int subArraysWithKDistinct(int[] A, int K) {
        if (A.length==0 || K > A.length || K <=0) {
            return 0;
        }
        int len = A.length;
        int left = 0, right = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < len) {
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            if (map.size() > K) {
                // 字典中个数超过K，窗口左端右移，直到窗口字典个数等于K
                while (left <= right) {
                    map.put(A[left], map.getOrDefault(A[left], 0)-1);
                    if (map.get(A[left]) == 0) {
                        map.remove(A[left]);
                        left += 1;
                        break;
                    }
                    left += 1;
                }
            }
            if (map.size() == K) {
                // 计算字典窗口中的元素，有多少符合的子数组
                Map<Integer, Integer> temp = new HashMap<>(map);
                for (int i=left; i<=right; i++) {
                    res += 1;
                    temp.put(A[i], temp.get(A[i])-1);
                    if (temp.get(A[i]) == 0) {
                        break;
                    }
                }
            }
            right += 1;
        }
        return res;
    }

    public static int subArraysWithKDistinct_1(int[] A, int K) {
        // ExactlyK = atMostK - atMostK-1
        return atMost(A, K) - atMost(A, K-1);
    }

    private static int atMost(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int left = 0;
        for (int i=0; i<n; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            while (map.size() > K) {
                map.put(A[left], map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) {
                    // 删除频次为0的元素
                    map.remove(A[left]);
                }
                left += 1;
            }
            // 计算个数
            cnt += i - left + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int result = subArraysWithKDistinct_1(nums, 2);
    }
}
