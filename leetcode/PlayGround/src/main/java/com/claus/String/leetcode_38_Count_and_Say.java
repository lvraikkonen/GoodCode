package com.claus.String;

import java.util.HashMap;
import java.util.Map;

public class leetcode_38_Count_and_Say {

    private static final Map<Integer, String> cache = new HashMap<Integer, String>() { {put(1, "1");} };

    public String countAndSay(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        String res = count(countAndSay(n - 1));
        cache.put(n, res);
        return res;
    }

    private String count(String s) {
        s += "#";
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char last = s.charAt(0);
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (last == c) {
                cnt++;
            } else {
                sb.append(cnt + "");
                sb.append(s.charAt(i-1));
                cnt = 1;
            }
            last = c;
        }
        return sb.toString();
    }

    public String countAndSay_recursive(int n) {
        // 递归法
        if (n == 1) return "1";

        // 上一个的结果
        String last = countAndSay_recursive(n - 1);

        // 计算本次的结果
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < last.length(); j++) {
            // 存储每个字符连续出现的次数
            int count = 1;
            while (j + 1 < last.length() && last.charAt(j + 1) == last.charAt(j)) {
                count++;
                j++;
            }
            sb.append(count).append(last.charAt(j));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        leetcode_38_Count_and_Say solution = new leetcode_38_Count_and_Say();
        String res = solution.countAndSay(5);
    }
}
