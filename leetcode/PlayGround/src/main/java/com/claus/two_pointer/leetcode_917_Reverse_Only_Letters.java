package com.claus.two_pointer;

public class leetcode_917_Reverse_Only_Letters {

    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i=0, j=n-1; i<j;) {
            while (i < j && !Character.isLetter(cs[i])) { // 如果当前指针指向不是字母，则移动
                i++;
            }
            while (i < j && !Character.isLetter(cs[j])) {
                j--;
            }
            if (i < j) {
                // 交换
                char c = cs[i];
                cs[i] = cs[j];
                cs[j] = c;
                i++;
                j--;
            }
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        leetcode_917_Reverse_Only_Letters solution = new leetcode_917_Reverse_Only_Letters();
        String res = solution.reverseOnlyLetters(s);
    }
}
