package com.claus.binarySearch;

public class leetcode_167_Two_Sum_II_Input_Array_Is_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        // numbers 有序, 双指针写法
        if (numbers==null) {
            return null;
        }
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[] { low + 1, high + 1};
            } else if (sum < target) {
                low += 1;
            } else if (sum > target) {
                high -= 1;
            }
        }
        return null;
    }

    public int[] twoSum_binarySearch(int[] numbers, int target) {
        // 二分法，固定一个值每次，用二分法在数组[i+1, len-1]中查找另一个值
        for (int i=0; i < numbers.length; i++) {
            int low = i+1, high = numbers.length-1;
            while (low <= high) {
                int mid = low + (high-low)/2;
                if (numbers[mid] == target-numbers[i]) {
                    return new int[] {i+1, mid+1};
                } else if (numbers[mid] > target-numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        int target = 9;
        leetcode_167_Two_Sum_II_Input_Array_Is_Sorted s = new leetcode_167_Two_Sum_II_Input_Array_Is_Sorted();
        int[] res = s.twoSum(num, target);
    }
}
