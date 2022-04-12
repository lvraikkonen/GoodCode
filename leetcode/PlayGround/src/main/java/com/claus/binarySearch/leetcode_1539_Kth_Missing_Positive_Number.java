package com.claus.binarySearch;

public class leetcode_1539_Kth_Missing_Positive_Number {

    public int findKthPositive(int[] arr, int k) {
        // 找出arr[i]-i-1 > 0，缺失越多，相差越大
        int low_idx = 0, high_idx = arr.length;
        while (low_idx < high_idx) {
            int mid_idx = low_idx + (high_idx-low_idx)/2;
            if (arr[mid_idx] - mid_idx >= k+1) {
                high_idx = mid_idx;
            } else if (arr[mid_idx] - mid_idx < k+1) {
                low_idx = mid_idx + 1;
            }
        }
        return low_idx + k;
    }

    public int findKthPositive_1(int[] arr, int k) {
//        如果数组中没有小于k的数，那么第k个缺失的数字就是k
//        如果有一个<=K的数字，k++
//        最后返回k
//        时间复杂度O(n) 空间复杂度O(1)
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] <= k) {
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        leetcode_1539_Kth_Missing_Positive_Number s = new leetcode_1539_Kth_Missing_Positive_Number();
        int res = s.findKthPositive_1(arr, 5);
    }
}
