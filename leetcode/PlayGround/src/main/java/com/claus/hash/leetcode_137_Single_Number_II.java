package com.claus.hash;

import java.util.HashMap;
import java.util.Map;

public class leetcode_137_Single_Number_II {
    /*
    数组中一个数字出现一次，剩下的出现三次
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int singleNumber_bit(int[]  nums) {
        int res = 0;
        for (int i=0; i<32; i++) {
            // 统计第i为1的个数
            int oneCount = 0;
            for (int j=0; j<nums.length; j++) {
                oneCount += (nums[j] >>> i) & 1;
            }
            //如果1的个数不是3的倍数，说明那个只出现一次的数字
            //的二进制位中在这一位是1
            if (oneCount % 3 == 1) {
                res |= 1 << i;
            }
        }
        return res;
    }
    /*
    如果只有一个数字出现一次，其他数字都出现奇数次，我们可以用下面代码来解决

    // n是出现的次数
    public int findOnce(int[] nums, int n) {
        int bitLength = 32;
        int res = 0;
        for (int i = 0; i < bitLength; i++) {
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++) {
                oneCount += (nums[j] >>> i) & 1;
            }
            if (oneCount % n != 0)
                res |= (1 << i);
        }
        return res;
    }
     */

    public static void main(String[] args) {
        int[]  nums = {2,2,3,2};
        int res = singleNumber_bit(nums);
    }
}
