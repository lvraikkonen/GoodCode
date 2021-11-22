package com.claus.DP;

import java.util.HashMap;
import java.util.Map;

public class leetcode_397_Integer_Replacement {
    // 记忆化搜索
    private Map<Integer, Integer> cache = new HashMap<>();

    public int integerReplacement(int n) {
        if (cache.containsKey(n)) { // 缓存中有答案，返回
            return cache.get(n);
        }

        if (n == 1) return 0;
        if (n == Integer.MAX_VALUE) return 32; // 防止溢出

        int ans = 0;
        if (n % 2 == 1) { // 奇数
            ans = Math.min(integerReplacement(n-1)+1, integerReplacement(n+1)+1);
        } else { // 偶数
            ans = integerReplacement(n/2) + 1;
        }
        cache.put(n, ans);

        return ans;
    }

    public static void main(String[] args) {
        leetcode_397_Integer_Replacement solution = new leetcode_397_Integer_Replacement();
        int res = solution.integerReplacement(7);
    }
}
