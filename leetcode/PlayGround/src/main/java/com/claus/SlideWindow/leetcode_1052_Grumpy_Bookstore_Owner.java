package com.claus.SlideWindow;

public class leetcode_1052_Grumpy_Bookstore_Owner {

    public static int maxSatisified(int[] customers, int[] grumpy, int X) {
        int win_sum = 0;
        int right_sum = 0;
        int len = customers.length;
        // 初始右侧的满意客户总和
        for (int i=X; i<len; i++) {
            if (grumpy[i] == 0) {
                right_sum += customers[i];
            }
        }
        // 窗口X中，老板放大招了，来的顾客都满意
        for (int i=0; i<X; i++) {
            win_sum += customers[i];
        }
        int left_sum = 0;
        // 最开始的窗口边缘
        int left = 1, right = X;
        int max_cus = left_sum + win_sum + right_sum;
        while (right < len) {
            // 左区间
            if (grumpy[left-1] == 0) {
                left_sum += customers[left-1];
            }
            // 右区间
            if (grumpy[right] == 0) {
                right_sum -= customers[right];
            }
            // 窗口
            win_sum = win_sum - customers[left-1] + customers[right];
            max_cus = Math.max(max_cus, win_sum+left_sum+right_sum);
            // 移动窗口
            left += 1;
            right += 1;
        }
        return max_cus;
    }

    /* 精简方法：
    首先求出不放大招时候满意客户总和 (用乘法)
    然后计算在滑动窗口内被变成满意客户的总和，取最大值
     */
    public static int maxSatisified_1(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int origin_satisified_sum = 0;
        for (int i=0; i<len; i++) {
            origin_satisified_sum += customers[i] * (1-grumpy[i]);
        }
        int extra = 0;
        // 最初的长为X的窗口
        for (int i=0; i<X; i++) {
            extra += customers[i] * grumpy[i];
        }
        int max_extra = extra;
        // 滑动窗口
        for (int i=X; i<len; i++){
            extra = extra + customers[i]*grumpy[i] - customers[i-X]*grumpy[i-X];
            max_extra = Math.max(max_extra, extra);
        }
        return origin_satisified_sum + max_extra;
    }

    public static void main(String[] args) {
        int[] cus = {1,0,1,2,1,1,7,5};
        int[] gru = {0,1,0,1,0,1,0,1};
        int res = maxSatisified_1(cus, gru, 3);
    }
}
