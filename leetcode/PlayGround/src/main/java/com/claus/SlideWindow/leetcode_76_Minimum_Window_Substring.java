package com.claus.SlideWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode_76_Minimum_Window_Substring {
    /*
    t 字符串中元素不重复
     */
    public static String minWindow_1(String s, String t) {
        Set<Character> need = new HashSet<>();
        Map<Character,Integer> window=new HashMap<>();

        for (Character c: t.toCharArray()) {
            need.add(c);
        }
        int left=0, right=0, count=0;
        int resLeft=s.length(), minLen=s.length()+1;

        while (right<s.length()){
            char ch_right = s.charAt(right);
            if (need.contains(ch_right)){
                window.put(ch_right, window.getOrDefault(ch_right, 0)+1);
                // small中元素第一次出现
                if (window.get(ch_right)==1){
                    count++;
                }
            }
            while (count==t.length()){
                // 窗口满足条件，首先更新结果，尝试移动左边界
                if (right-left+1<minLen){
                    minLen=right-left+1;
                    resLeft=left;
                }
                if (need.contains(s.charAt(left))){
                    // 窗口去掉左端元素
                    window.put(s.charAt(left), window.get(s.charAt(left))-1);

                    if (window.get(s.charAt(left))==0){
                        count--;
                    }
                }
                left++;
            }
            right++;
        }
        if (minLen == s.length() + 1) {
            return "";
        }
        return s.substring(resLeft, resLeft + minLen);
    }


    /*
    t 字符串中元素有可能重复
    记录t中元素出现的次数
     */
    public static String minWindow(String s, String t) {
        //维护两个数组，记录已有字符串指定字符的出现次数，和目标字符串指定字符的出现次数
        int[] need = new int[128];
        int[] have = new int[128];
        for (int i=0; i<t.length(); i++) {
            need[t.charAt(i)] += 1;
        }
        int count = 0;
        int left=0, right=0, resLeft=s.length(), minLen = s.length()+1;
        while (right < s.length()) {
            char ch_right = s.charAt(right);
            if (need[ch_right]==0) {
                // 该字符不被需要
                right++;
                continue;
            }
            if (have[ch_right] < need[ch_right]) {
                // 已有字符串目标字符出现的次数小于目标字符串字符的出现次数时，count才会+1
                count += 1;
            }
            have[ch_right] += 1;
            while (count==t.length()) {
                // 窗口满足条件，首先更新结果，尝试移动左边界
                if (right-left+1 < minLen) {
                    minLen = right-left+1;
                    resLeft = left;
                }
                char ch_left = s.charAt(left);
                if (need[ch_left]==0) {
                    // 如果左边界元素不被需要
                    left += 1;
                    continue;
                }
                if (have[ch_left] == need[ch_left]) {
                    count -= 1;
                }
                have[ch_left] -= 1;
                left++;
            }
            right++;
        }
        if (minLen == s.length() + 1) {
            return "";
        }
        return s.substring(resLeft, resLeft + minLen);
    }

    public String minWindow_2(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) { //需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放左边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
        String s1 = "abacbd";
        String s2 = "aab";
        String res = minWindow(s1, s2);
    }
}
