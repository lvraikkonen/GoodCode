package com.claus.math;

public class leetcode_273_Integer_to_English_Words {

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        if (num == 1) return "One";
        if (num == 2) return "Two";
        if (num == 3) return "Three";
        if (num == 4) return "Four";
        if (num == 5) return "Five";
        if (num == 6) return "Six";
        if (num == 7) return "Seven";
        if (num == 8) return "Eight";
        if (num == 9) return "Nine";
        if (num == 10) return "Ten";
        if (num == 11) return "Eleven";
        if (num == 12) return "Twelve";
        if (num == 13) return "Thirteen";
        if (num == 14) return "Fourteen";
        if (num == 15) return "Fifteen";
        if (num == 16) return "Sixteen";
        if (num == 17) return "Seventeen";
        if (num == 18) return "Eighteen";
        if (num == 19) return "Nineteen";
        if (num == 20) return "Twenty";
        if (num == 30) return "Thirty";
        if (num == 40) return "Forty";
        if (num == 50) return "Fifty";
        if (num == 60) return "Sixty";
        if (num == 70) return "Seventy";
        if (num == 80) return "Eighty";
        if (num == 90) return "Ninety";
        if (num <= 99) {
            return numberToWords(num / 10 * 10) + numberToSubstringIfNotZero(num % 10);
        } else if (num <= 999) {
            return numberToWords(num / 100) + " Hundred" + numberToSubstringIfNotZero(num % 100);
        } else if (num <= 999999) {
            return numberToWords(num / 1000) + " Thousand" + numberToSubstringIfNotZero(num % 1000);
        } else if (num <= 999999999) {
            return numberToWords(num / 1000000) + " Million" + numberToSubstringIfNotZero(num % 1000000);
        } else {
            return numberToWords(num / 1000000000) + " Billion" + numberToSubstringIfNotZero(num % 1000000000);
        }
    }

    private String numberToSubstringIfNotZero(int num) {
        if (num == 0) {
            return "";
        } else {
            return " " + numberToWords(num);
        }
    }

    public String numberToWords_bak(int num) {
        String[] one = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] two = new String[]{"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if(num >= 1000000000){
            if(num % 1000000000 == 0)
                return numberToWords(num / 1000000000) + " Billion";
            return numberToWords(num / 1000000000) + " Billion " + numberToWords(num % 1000000000);
        }
        if(num >= 1000000){
            if(num % 1000000 == 0)
                return numberToWords(num / 1000000) + " Million";
            return numberToWords(num / 1000000) + " Million " + numberToWords(num % 1000000);
        }
        if(num >= 1000){
            if(num % 1000 == 0)
                return numberToWords(num / 1000) + " Thousand";
            return numberToWords(num / 1000) + " Thousand " + numberToWords(num % 1000);
        }
        if(num >= 100){
            if(num % 100 == 0)
                return numberToWords(num / 100) + " Hundred";
            return numberToWords(num / 100) + " Hundred " + numberToWords(num % 100);
        }
        if(num % 10 == 0)
            return two[num/10];
        if(num > 20)
            return numberToWords(num /10 *10) + " " + numberToWords(num % 10);
        return one[num];
    }

    public static void main(String[] args) {
        int num = 12345;
        leetcode_273_Integer_to_English_Words obj = new leetcode_273_Integer_to_English_Words();
        String res = obj.numberToWords(num);
    }
}
