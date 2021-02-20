package com.claus.SlideWindow;

public class leetcode_1423_Maximum_Points_You_Can_Obtain_from_Cards {

    /*
    反向操作
    维护一个len-k的窗口，保证窗口里面和最小，然后剩余的k个数的和就是最大
     */
    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        // 取滑动窗口为总长度减去头尾k个元素长
        int windowSize = len - k;
        // 选取前len-k为初始窗口
        int sum = 0;
        for (int i=0; i<windowSize; i++) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i=windowSize; i<len; i++) {
            // 窗口向右移动一格，窗口左侧减少一个，右侧增加一个
            sum += cardPoints[i] - cardPoints[i-windowSize];
            minSum = Math.min(minSum, sum);
        }
        // 返回的窗口外最大值，为整个数组总和减去滑动窗口最小值
        int array_sum = 0;
        for (int i=0; i<len; i++) {
            array_sum += cardPoints[i];
        }
        return array_sum - minSum;
    }

    public static void main(String[] args) {
        int[] cards = {1,2,3,4,5,6,1};
        int result = maxScore(cards, 3);
    }
}
