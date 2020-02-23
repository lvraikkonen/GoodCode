/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: leetcode_378_Kth_Smallest_Element_in_a_Sorted_Matrix
 * Author:   lvshuo
 * Date:     2020/2/23 15:39
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
public class leetcode_378_Kth_Smallest_Element_in_a_Sorted_Matrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
            }
        }
        for (int i=0;i<k; i++) {
            int val = pq.poll();
            if (i==k-1) {
                return val;
            }
        }
        return 0;
    }
}