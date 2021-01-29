package com.claus.array;

import java.util.LinkedList;
import java.util.List;

public class leetcode_989_Add_to_Array_Form_of_Integer {

    public static List<Integer> addToArrayFrom(int[] A, int K) {
        int n = A.length;
        LinkedList<Integer> res = new LinkedList<>();
        int sum = 0, carry = 0;
        for (int i = n-1; i>=0 || K!=0; K = K/10, i--) {
            int x = i >= 0 ? A[i] : 0;
            int y = K != 0 ? K%10 : 0;

            sum = x + y + carry;
            carry = sum / 10;
            res.addFirst(sum%10);
        }
        // 最后还有进位
        if (carry != 0) {
            res.add(0, carry);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5};
        int K = 806;
        addToArrayFrom(nums, K);
    }
}
