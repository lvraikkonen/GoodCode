package com.claus.two_pointer;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode_287_Find_the_Duplicate_Number {
    public static int findDuplicate_1(int[] nums) {
        // 排序
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == nums[i+1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findDuplicate_2(int[] nums) {
        // HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    public static int findDuplicate_3(int[] nums) {
        // 二分查找
        if(nums == null || nums.length == 0){
            return 0;
        }

        /*
        arr = [1,3,4,2,2] 此时数字在 1 — 5 之间

                mid = (1 + 5) / 2 = 3 arr小于等于的3有4个(1,2,2,3)，1到3中肯定有重复的值
                mid = (1 + 3) / 2 = 2 arr小于等于的2有3个(1,2,2)，1到2中肯定有重复的值
                mid = (1 + 2) / 2 = 1 arr小于等于的1有1个(1)，2到2中肯定有重复的值
        所以重复的数是 2
         */

        int left = 1;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i ++){
                if(nums[i] <= mid){
                    count ++;
                }
            }

            if(count > mid){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findDuplicate_4(int[] nums) {
        // 快慢指针法
        int slow = nums[0];
        int fast = nums[nums[0]];
        //寻找相遇点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //slow 从起点出发, fast 从相遇点出发, 一次走一步
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,5};
        int res = findDuplicate_3(nums);
    }
}
