package com.claus.binarySearch;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class leetcode_278_First_Bad_Version {
    public boolean isBadVersion(int version) {
        if (version > 5) return true;
        else return false;
    }

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;

        while (low < high) {
            int mid = low + ((high-low)>>1);
             if (isBadVersion(mid)) {
                 high = mid;
             } else {
                 low = mid + 1;
             }
        }
        return low;
    }

    public static void main(String[] args) {
        leetcode_278_First_Bad_Version solution = new leetcode_278_First_Bad_Version();
        int res = solution.firstBadVersion(9);
    }
}
