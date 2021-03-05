package com.claus.math;

public class leetcode_136_Single_Number {
    /*
    异或运算有以下三个性质。

    1. 任何数和 0 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
    2. 任何数和其自身做异或运算，结果是 0，即 a \oplus a=0a⊕a=0。
    3. 异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b

     */
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num: nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int res = singleNumber(nums);
    }
}
