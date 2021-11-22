package com.claus.sort;

import java.util.Arrays;

public class leetcode_1833_Maximum_Ice_Cream_Bars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int i = 0; i < costs.length && coins >= 0; i++) {
            coins -= costs[i];
            if (coins >= 0) {
                res += 1;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        leetcode_1833_Maximum_Ice_Cream_Bars solution = new leetcode_1833_Maximum_Ice_Cream_Bars();
        int res = solution.maxIceCream(costs, coins);
    }
}
