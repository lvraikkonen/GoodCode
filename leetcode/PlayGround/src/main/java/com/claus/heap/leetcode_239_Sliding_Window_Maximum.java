/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: leetcode_239_Sliding_Window_Maximum
 * Author:   lvshuo
 * Date:     2020/2/23 15:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.claus.heap;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 * 用双向队列存储数组的下标,每一轮进行移动窗口、维护和输出的动作
 * 每一轮使最大的数对应的下标在双向队列的最左端，如果双向队列中“左边下标对应的元素”要小于“右边下标对应的元素”，那么就把左边的元素进行清除维护
 * 输出双向队列最左端下标对应的元素
 *
 * @author lvshuo
 * @create 2020/2/23
 * @since 1.0.0
 */
public class leetcode_239_Sliding_Window_Maximum {

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 )
            return nums;
        Deque<Integer> deque=new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if(!deque.isEmpty() && deque.peekFirst()<i-(k-1))
                deque.removeFirst();
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i])
                deque.removeLast();
            deque.offerLast(i);
            if(i>=k-1){
                ans[i-(k-1)]=nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}