package com.claus.binarySearch;

public class leetcode_744_Find_Smallest_Letter_Greater_Than_Target {
    // 顺序查找
    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        char nextGreatest = letters[0];
        for (int i=0; i < length; i++) {
            if (letters[i] > target) {
                nextGreatest = letters[i];
                break;
            }
        }
        return nextGreatest;
    }

    // 二分查找
    public char nextGreatestLetter_binarySearch(char[] letters, char target) {
        // 首先比较最后面一个字母，如果target大于等于最后一个元素，则取letters第一个元素
        int length = letters.length;
        if (target >= letters[length-1]) {
            return letters[0];
        }
        // 二分
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return letters[low];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c','f','j'};
        char target = 'd';
        leetcode_744_Find_Smallest_Letter_Greater_Than_Target s = new leetcode_744_Find_Smallest_Letter_Greater_Than_Target();
        char res = s.nextGreatestLetter_binarySearch(letters, target);
    }
}
