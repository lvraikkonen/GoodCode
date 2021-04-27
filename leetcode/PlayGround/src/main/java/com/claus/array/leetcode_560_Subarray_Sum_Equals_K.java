package com.claus.array;

import java.util.HashMap;
import java.util.Map;

public class leetcode_560_Subarray_Sum_Equals_K {
    public static int subarraySum_1(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int left=0; left < len; left++) {
            int sum = 0;
            for (int right=left; right<len; right++) {
                sum += nums[right];
                if (sum == k) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static int subarraySum_2(int[] nums, int k) {
        // 前缀和
        int len = nums.length;
        int[] presum = new int[len+1];
        presum[0] = 0;
        for (int i=0; i<len;i++) {
            presum[i+1] = presum[i] + nums[i];
        }

        int count = 0;
        for (int left=0; left < len; left++) {
            for (int right=left; right<len; right++) {
                // 前缀和求区间值
                if (presum[right+1] - presum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum_3(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //map保存映射 序列和：等于该序列和的数量

        int sum = 0;
        int ans=0;
        map.put(0,1);//初始化，代表：序列和为0的值 初始只有1个。
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            //存在从某个子序列和 presum 到 当前的序列和 sum 差值刚好为k的值，
            //中间的值必然是连续的
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            //序列和存在的话，设置为原始数量+1，不存在则初始设为0
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int res = subarraySum_3(nums, 2);
    }
}
