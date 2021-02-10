package com.claus.SlideWindow.atMostK;

import java.util.HashMap;
import java.util.Map;

public class leetcode_159_Longest_Substring_with_At_Most_Two_Distinct_Characters {

    /*
    哈希表或者数组维护窗口中<元素，出现次数>

    for (枚举右边界)) {
        右边界频次
        while (元素种类 > K)) {
            左边界频次
            去除频次为0的元素（哈希表的情况）
            缩左边界
        }
        更新结果
    }
    返回结果

     */

    /*
    至多包含两个不同字符的最长子串
     */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int i=0; i < s.length(); i++) {
            char ch_right = s.charAt(i);
            map.put(ch_right, map.getOrDefault(ch_right, 0) + 1);

            while (map.size() > 2) {
                char ch_left = s.charAt(left);
                map.put(ch_left, map.get(ch_left) - 1);
                if (map.get(ch_left) == 0) {
                    map.remove(ch_left);
                }
                left += 1;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abacbad";
        int result = lengthOfLongestSubstringTwoDistinct(s);
    }
}
