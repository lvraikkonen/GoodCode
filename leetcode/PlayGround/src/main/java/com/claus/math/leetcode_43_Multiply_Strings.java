package com.claus.math;

public class leetcode_43_Multiply_Strings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        // num2 逐位与num1相乘
        for (int i = num2.length()-1; i>=0; i--) {
            StringBuilder tmp = new StringBuilder();
            int carry = 0;
            for (int j=0; j<num2.length()-1-i; j++) {
                tmp.append(0);
            }
            int n2 = num2.charAt(i) - '0';
            // n2 与num1相乘
            for (int j=num1.length()-1; j>=0 || carry!=0 ; j--) {
                int n1 = j>=0 ? num1.charAt(j)-'0' : 0;
                int product = (n1 * n2 + carry);
                carry = product / 10;
                tmp.append(product % 10);
            }
            res = addStrings(res, tmp.reverse().toString());
        }
        return res;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i>=0 || j>=0) {
            int n1 = i>=0 ? num1.charAt(i) - '0' : 0;
            int n2 = j>=0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            sb.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public String multiply_improve(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m-1; i>=0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = n-1; j>=0; j--) {
                int n2 = num2.charAt(j) - '0';
                // 乘积在 res 对应的索引位置
                int p1 = i + j;
                int p2 = i + j + 1;
                // 叠加到 res 上
                int tmp = (n1 * n2) + res[p2];
                res[p2] = tmp % 10;
                res[p1] += tmp / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i=0; i < res.length; i++) {
            if (i==0 && res[i]==0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        leetcode_43_Multiply_Strings solution = new leetcode_43_Multiply_Strings();
        String res = solution.multiply_improve("123", "45");
    }
}
