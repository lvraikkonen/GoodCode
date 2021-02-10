package com.claus.two_pointer;

public class leetcode_121_Best_Time_to_Buy_and_Sell_Stock {
    public static int maxProfit(int[] prices) {
        if (prices.length==0) {
            return 0;
        }
        int current_min = prices[0];
        int max_profit = 0;
        for (int i=1; i<prices.length; i++) {
            current_min = Math.min(current_min, prices[i]);
            max_profit = Math.max(max_profit, prices[i]-current_min);
        }
        return max_profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
    }
}
