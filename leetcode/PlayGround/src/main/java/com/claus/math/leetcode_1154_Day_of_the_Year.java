package com.claus.math;

public class leetcode_1154_Day_of_the_Year {

    static int[] nums = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] f = new int[13]; // 第i个月过完之后经过了多少天

    static {
        for (int i=1; i <=12; i++) {
            f[i] = f[i-1] + nums[i-1];
        }
    }

    public int dayOfYear(String date) {
        String[] ss = date.split("-");
        int y = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]), d = Integer.parseInt(ss[2]);
        boolean isLeap = (y % 4 == 0 && y % 100 != 0) || y%400 == 0;
        int ans = m > 2 && isLeap ? f[m-1]+1 : f[m-1];
        return ans + d;
    }

    public static void main(String[] args) {
        String date = "2003-03-01";
        leetcode_1154_Day_of_the_Year s = new leetcode_1154_Day_of_the_Year();
        int res = s.dayOfYear(date);
    }
}
