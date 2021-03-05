package com.claus.hash;

import com.claus.linkedList.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_438_Find_All_Anagrams_in_a_String {
    public static List<Integer> findAnagrams(String s, String p) {
        char[] arr_s = s.toCharArray();
        char[] arr_p = p.toCharArray();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26];
        int[] window = new int[26];

        for (int i=0; i<p.length(); i++) {
            needs[arr_p[i]-'a'] ++;
        }
        // 固定长度为p.length的窗口
        int left = 0, right = 0;
        while (right < s.length()) {
            char ch_right = arr_s[right];
            window[ch_right-'a'] += 1;
            while (window[ch_right-'a'] > needs[ch_right-'a']) {
                // 窗口不满足条件，左边界右移
                char ch_left = arr_s[left];
                left++;
                window[ch_left-'a'] -= 1;
            }
            if (right-left+1 == p.length()) {
                res.add(left);
            }
            right++;
        }
        return res;
    }

    public static List<Integer> findAnagrams_1(String s, String p) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26];
        int[] window = new int[26];
        //用total检测窗口中是否已经涵盖了p中的字符
        int left = 0, right = 0, total = p.length();
        for(char ch : p.toCharArray()){
            needs[ch - 'a'] ++;
        }
        while(right < s.length()){
            char chr = s.charAt(right);
            // 如果该字符是被需要的
            if(needs[chr - 'a'] > 0){
                window[chr - 'a'] ++;
                if(window[chr - 'a'] <= needs[chr - 'a']){
                    total --;
                }
            }
            // 窗口全部覆盖p的情况下
            while(total == 0){
                if(right-left+1 == p.length()){
                    res.add(left);
                }
                char chl = s.charAt(left);
                if(needs[chl - 'a'] > 0){
                    window[chl - 'a'] --;
                    if(window[chl - 'a'] < needs[chl - 'a']){
                        total ++;
                    }
                }
                left ++;
            }
            right ++;
        }
        return res;
    }

    public static List<Integer> findAnagrams_2(String s, String p) {
        if(s == null || s.length() < p.length()) return new ArrayList<Integer>();

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        char[] sArr = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        for(char c : p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int sLen = sArr.length;
        int valid = 0;

        while(right < sLen) {
            char c = sArr[right];
            right++;

            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            if(valid == need.size()) {
                res.add(left);
            }

            if(right < p.length()) continue;

            char d = sArr[left];
            left++;

            if(need.containsKey(d)){
                if(window.get(d).equals(need.get(d))) {
                    valid--;
                }
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String s2 = "abc";
        List<Integer> res = findAnagrams_1(s1, s2);
    }
}
