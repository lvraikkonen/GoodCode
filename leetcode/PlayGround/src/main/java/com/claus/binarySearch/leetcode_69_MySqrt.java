package com.claus.binarySearch;

public class leetcode_69_MySqrt {
    public int mySqrt(int x) {
        int low = 0, high=x;
        int res = 0;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (mid*mid <= x) {
                res = mid;
                low = mid+1;
            } else if (mid*mid > x) {
                high = mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode_69_MySqrt s = new leetcode_69_MySqrt();
        int res = s.mySqrt(8);
    }
}
