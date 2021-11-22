package com.claus.hash;

import java.util.*;

public class leetcode_187_Repeated_DNA_Sequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i+10 <= n; i++) {
            String curr = s.substring(i, i+10);
            int cnt = map.getOrDefault(curr, 0);
            if (cnt == 1) {
                // 已经出现过
                res.add(curr);
            }
            map.put(curr, cnt + 1);
        }
        return res;
    }



    // 把ACGT四个字符映射到2位的数字
    static int[] MASK_MAP = new int[26];
    static {
        MASK_MAP['A' - 'A'] = 0;
        MASK_MAP['C' - 'A'] = 1;
        MASK_MAP['G' - 'A'] = 2;
        MASK_MAP['T' - 'A'] = 3;
    }

    public List<String> findRepeatedDnaSequences_bit(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if (n <= 10) {
            return ans;
        }

        // 记录每个hash出现的次数
        int[] map = new int[1 << 20];
        int hash = 0;
        for (int i = 0; i < 10; i++) {
            // 每2位一个字符
            hash = hash << 2 | MASK_MAP[s.charAt(i) - 'A'];
        }
        map[hash]++;

        for (int i = 1; i <= n - 10; i++) {
            // & 0xfffff 表示打掉最高位的2位
            hash = (hash << 2 | MASK_MAP[s.charAt(i + 10 - 1) - 'A']) & 0xfffff;
            map[hash]++;
            // 因为不存在hash冲突，所以可以直接使用
            if (map[hash] == 2) {
                ans.add(s.substring(i, i + 10));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        leetcode_187_Repeated_DNA_Sequences solution = new leetcode_187_Repeated_DNA_Sequences();
        List<String> res = solution.findRepeatedDnaSequences(s);
    }
}
