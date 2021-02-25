package com.claus.SlideWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class interview_17_18_Shortest_Supersequence_LCCI {
    public static int[] shortestSeq(int[] big, int[] small) {
        Set<Integer> need = new HashSet<>();
        Map<Integer,Integer> window=new HashMap<>();
        for (int i=0; i<small.length; i++)
            need.add(small[i]);
        int left=0, right=0, count=0;
        int resLeft=big.length, resRight=big.length, minLen=big.length+1;
        int[] res=new int[2];
        while (right<big.length){
            if (need.contains(big[right])){
                window.put(big[right], window.getOrDefault(big[right], 0)+1);
                // small中元素第一次出现
                if (window.get(big[right])==1){
                    count++;
                }
            }
            while (count==small.length){
                // 窗口满足条件，首先更新结果，尝试移动左边界
                if (right-left+1<minLen){
                    minLen=right-left+1;
                    resLeft=left;
                    resRight=right;
                }
                if (need.contains(big[left])){
                    // 窗口去掉左端元素
                    window.put(big[left], window.get(big[left])-1);

                    if (window.get(big[left])==0){
                        count--;
                    }
                }
                left++;
            }
            right++;
        }
        if (resRight<big.length){
            res[0]=resLeft;
            res[1]=resRight;
            return res;
        }
        else
            return new int[0];
    }

    public static void main(String[] args) {
        int[] big = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] small = {1,5,9};
        int[] res = shortestSeq(big,small);
    }
}
