package com.claus.SlideWindow;

import java.util.HashMap;
import java.util.Map;

public class leetcode_697_Degree_of_an_Array {
    /*
    给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。

    你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

    示例 1：

    输入：[1, 2, 2, 3, 1]
    输出：2
    解释：
    输入数组的度是2，因为元素1和2的出现频数最大，均为2.
    连续子数组里面拥有相同度的有如下所示:
    [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
    最短连续子数组[2, 2]的长度为2，所以返回2.

     */
    /*
    方法：首先求出数组的度
    然后转变成滑动窗口问题，
     */
    public static int getDegree(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            res = Math.max(res, map.get(num));
        }
        return res;
    }

    public static int findShortestSubArray(int[] nums) {
        int left = 0, right = 0;
        int len = nums.length;
        int res = len + 1;
        int maxDegree = getDegree(nums);

        int[] map = new int[50010];
        while (right < len) {
            map[nums[right]] += 1;
            // 判断窗口是否符合条件
            while (map[nums[right]] == maxDegree) {
                // 满足频数后，移动左侧边界
                res = Math.min(res, right-left+1);
                map[nums[left]] -= 1;
                left += 1;
            }
            right += 1;
        }
        return res;
    }

    /*
    方法2：最短子数组的起始和终止位置，由出现次数最多的元素的第一次和最后一次出现的位置确定
    定义一个Map，key为数组元素，value数组为{频数, 第一次出现的位置, 最后一次出现的位置}
    如果有相同的最大频数，则取最小的结果
     */
    public static int findShortestSubArray_2(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int len = nums.length;
        int maxDegree = 0;
        //遍历数组，将每一个元素出现的次数、第一次出现的位置、最后一次出现的位置记录下来
        for (int i=0; i<len; i++) {
            if (map.containsKey(nums[i])) {
                // 更新出现的位置
                map.get(nums[i])[0] ++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
            maxDegree = Math.max(maxDegree, map.get(nums[i])[0]);
        }

        int res = Integer.MAX_VALUE;

        // 遍历Map, 寻找出现频数最多的Key, 若有相同的，选择(last-first)最短的
        for (Map.Entry<Integer, int[]> entry: map.entrySet()) {
            int[] temp = entry.getValue();
            if (temp[0] == maxDegree) {
                res = Math.min(res, temp[2]-temp[1]+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        int res = findShortestSubArray_2(nums);
    }
}
