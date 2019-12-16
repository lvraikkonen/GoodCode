package com.claus.BinarySearch;

public class BinarySearch_Variant {

    /**
     * 二分查找变种1
     * 查找第一个值等于给定值的元素
     */
    public static int bsearch_var1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low)>>1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ( (mid==0) || (a[mid-1] != value)) return mid; // 确认a[mid]是否是第一个
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变种2
     * 查找最后一个值等于给定值的元素
     */
    public static int bsearch_var2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (a[mid] < value){
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid==n-1) || (a[mid+1] != value)) return mid; // 确认a[mid]是否是最后一个等于value的元素
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变种3
     * 查找第一个大于等于给定值的元素
     */
    public static int bsearch_var3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (a[mid] >= value) { // 第一个大于等于给定值
                if ((mid==0) || (a[mid-1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变种4
     * 查找最后一个小于等于给定值的元素
     */
    public static int bsearch_var4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid==n-1) || (a[mid+1]>value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        int[] a = {3,5,6,8,9,10};
        System.out.println(bsearch_var4(a, 6, 7));
    }
}
