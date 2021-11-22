package com.claus.array;

import java.util.Random;

public class leetcode_384_Shuffle_an_Array {
    /*
    Knuth 洗牌算法，在 O(n) 复杂度内等概率返回某个方案。

    具体的，我们从前往后尝试填充 [0, n - 1]该填入什么数时，通过随机当前下标与（剩余的）哪个下标进行值交换来实现。

    对于下标 x 而言，我们从 [x, n - 1] 中随机出一个位置与 x 进行值交换，当所有位置都进行这样的处理后，我们便得到了一个公平的洗牌方案。

    对于下标为 0 位置，从 [0, n - 1] 随机一个位置进行交换，共有 n 种选择；下标为 1 的位置，从 [1, n - 1] 随机一个位置进行交换，共有 n - 1 种选择 ...
    且每个位置的随机位置交换过程相互独立。

     */

    int[] nums;
    int n;
    Random random = new Random();

    public leetcode_384_Shuffle_an_Array(int[] _nums) {
        nums = _nums;
        n = nums.length;
    }

    public int[] reset() {
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = 0; i < n; i++) {
            swap(ans, i, i+random.nextInt(n-i));
        }
        return ans;
    }
}
