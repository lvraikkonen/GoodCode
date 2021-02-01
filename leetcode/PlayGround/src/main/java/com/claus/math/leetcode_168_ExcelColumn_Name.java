package com.claus.math;

public class leetcode_168_ExcelColumn_Name {
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int mod = n % 26;
            if (mod == 0) {
                mod = 26;
                n -= 1;
            }
            sb.insert(0, (char)('A'+mod-1));
            n /= 26;
        }
        return sb.toString();
    }

    public static String convertToTitle1(int number) {
        StringBuilder sb = new StringBuilder();
        while(number > 0) {
            number--;
            sb.append((char)('A' + number % 26));
            number /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int num = 27;
        String res = convertToTitle1(num);
    }
}
