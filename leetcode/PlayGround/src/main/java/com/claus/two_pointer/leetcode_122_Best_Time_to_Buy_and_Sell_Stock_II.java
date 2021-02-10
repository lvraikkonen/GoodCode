package com.claus.two_pointer;

public class leetcode_122_Best_Time_to_Buy_and_Sell_Stock_II {

    public static int maxProfit(int[] prices) {
        // 只要今天比昨天大，就卖出
        if (prices.length==0) {
            return 0;
        }
        int max_profit = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                max_profit += (prices[i] - prices[i-1]);
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
    }
}
