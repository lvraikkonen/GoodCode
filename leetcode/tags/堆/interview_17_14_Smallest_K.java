/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: interview_17_14_Smallest_K
 * Author:   lvshuo
 * Date:     2020/2/23 15:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.claus.heap;

import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author lvshuo
 * @create 2020/2/23
 * @since 1.0.0
 */
public class interview_17_14_Smallest_K {

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        for (int num : arr)
            heap.offer(num);
        int[] res = new int[k];
        int idx = 0;
        while (idx < k) {
            res[idx++] = heap.poll();
        }
        return res;
    }

}