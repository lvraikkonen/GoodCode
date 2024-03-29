package com.claus.String;

public class leetcode_273_Integer_to_English_Words {

    static String[] num2str_small = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    static String[] num2str_medium = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    static String[] num2str_large = {
            "Billion", "Million", "Thousand", ""
    };

    // 千分位，每三个数字一组分割
    String num2Str(int x) {
        String ans = "";
        if (x >= 100) {
            ans += num2str_small[x / 100] + " Hundred ";
            x %= 100;
        }
        if (x >= 20) {
            ans += num2str_medium[x / 10] + " ";
            x %= 10;
        }
        if (x != 0) {
            ans += num2str_small[x] + " ";
        }
        return ans;
    }

    public String numberToWords(int num) {
        if (num == 0) return num2str_small[0];
        StringBuilder sb = new StringBuilder();
        for (int i= (int)1e9, j=0; i >= 1; i /= 1000, j++) {
            if (num < i) continue;
            sb.append(num2Str(num / i) + num2str_large[j] + " ");
            num %= i;
        }
        while (sb.charAt(sb.length()-1) == ' ') sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 1234567;
        leetcode_273_Integer_to_English_Words solution = new leetcode_273_Integer_to_English_Words();
        String res = solution.numberToWords(num);
    }
}
