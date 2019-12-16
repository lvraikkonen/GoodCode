package com.claus.BinarySearch;

public class SimpleBinarySearch {

    public static int bsearch(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low)>>1); // 防止lowhehigh很大溢出 (low+high)/2
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 递归实现
    public static int bsearch_recusion(int[] a, int n, int value) {
        return bsearchInternal(a, 0, n-1, value);
    }

    public static int bsearchInternal(int[] a, int low, int high, int value) {
        if (low > high)
            return -1;
        int mid = low + ((high - low)>>1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value){
            return bsearchInternal(a, mid+1, high, value);
        } else {
            return bsearchInternal(a, low, mid-1, value);
        }
    }

    public static void main(String[] args) throws Exception {
        int[] a = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        // System.out.println(bsearch(a, 10, 55));
        System.out.println(bsearch_recusion(a, 10, 55));
    }
}
