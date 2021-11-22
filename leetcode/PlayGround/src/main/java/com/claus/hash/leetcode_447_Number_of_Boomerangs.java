package com.claus.hash;

import java.util.HashMap;
import java.util.Map;

public class leetcode_447_Number_of_Boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int res = 0;
        for (int i=0; i < n; i++) {
            // 计算出 i 和其余点的距离，并以 { 距离 : 个数 } 的形式进行存储
            Map<Integer, Integer> map = new HashMap<>();
            for (int j=0; j < n; j++) {
                if (i == j) continue;
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int dist = x*x + y*y;
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }

            for (int dist: map.keySet()) {
                int cnt = map.get(dist);
                res += cnt * (cnt - 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};
        leetcode_447_Number_of_Boomerangs s = new leetcode_447_Number_of_Boomerangs();
        int res = s.numberOfBoomerangs(points);
    }
}
