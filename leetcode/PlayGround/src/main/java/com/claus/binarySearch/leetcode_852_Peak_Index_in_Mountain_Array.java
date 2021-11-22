package com.claus.binarySearch;

public class leetcode_852_Peak_Index_in_Mountain_Array {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + ((high-low)>>1);
            if (arr[mid] < arr[mid+1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        leetcode_852_Peak_Index_in_Mountain_Array solution = new leetcode_852_Peak_Index_in_Mountain_Array();
        int res = solution.peakIndexInMountainArray(arr);
    }
}
