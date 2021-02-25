package com.claus.math;

import java.util.Arrays;

public class leetcode_1356_Sort_Integers_by_The_Number_of_1_Bits {
    /*
    方法：
    根据 1的个数 和 当前数值，生成一个新的数字，来 存储 每一个数字 的 1的个数 和 本身的值
    接下来，将 存储的数字，还原成最初始的数字，并根据 1的个数 和 当前数值 排序
     */
    public static int[] sortByBits(int[] arr) {
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i] % 10000000;
        }
        return map;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8};
        int[] res = sortByBits(nums);
    }
}
