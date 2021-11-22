package com.claus.array;

public class leetcode_1894_Find_the_Student_that_Will_Replace_the_Chalk {

    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        int length = chalk.length;

        for (int i=0; i < length; i++) {
            sum += chalk[i];
            if (sum > k) { // 第一轮就没有粉笔了
                return i;
            }
        }

        if (sum == k){
            return 0;
        }

        int tmp = k % sum; // 取模减少遍历次数
        for (int i=0; i < length; i++) {
            tmp -= chalk[i];
            if (tmp == 0) {
                return i + 1; // 下一个补充
            } else if (tmp < 0) {
                return i; // 当前补充
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] chalk = {5, 1, 5};
        int k = 22;
        leetcode_1894_Find_the_Student_that_Will_Replace_the_Chalk s = new leetcode_1894_Find_the_Student_that_Will_Replace_the_Chalk();
        int res = s.chalkReplacer(chalk, k);
    }
}
