package com.claus.two_pointer;

public class leetcode_165_Compare_Version_Numbers {
    public static int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int len1 = nums1.length;
        int len2 = nums2.length;

        int i1, i2;
        for (int i=0; i < Math.max(len1,len2); i++) {
            i1 = i < len1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < len2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "7.5.2.4";
        String v2 = "7.5.3";
        int res = compareVersion(v1, v2);
    }
}
