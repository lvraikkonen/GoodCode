package com.claus.array;

import java.util.ArrayList;
import java.util.List;

public class leetcode_6_ZigZag {
    public static String convert(String s, int numRows) {
        // 如果只有一行，不用变换
        if(numRows==1){
            return s;
        }
        // 建立一个numRows的个数的字符串，每个字符串存放每一行的字符
        String[] result = new String[numRows];
        for(int i = 0; i < numRows; i++){
            result[i] = "";
        }

        // 按照z型给字符串中加入元素
        int i = 0, col_idx = 0;
        boolean direction = false;
        while(i < s.length())
        {
            result[col_idx] += s.charAt(i);
            // 判断方向
            if(col_idx == 0){
                direction = false;
            }
            // 最后一行
            if(col_idx == numRows -1) {
                direction = true;
            }
            col_idx = direction ? col_idx-1 : col_idx+1;
            i++;
        }
        // 逐行
        StringBuffer resultStr = new StringBuffer("");
        for(String str:result){
            resultStr.append(str);
        }
        return resultStr.toString();
    }

    public static String convert_1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 建立一个numRows的个数的字符串，每个字符串存放每一行的字符
        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0; i< Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        // 按照z型给字符串中加入元素
        boolean goingDown = false;
        int curRow = 0;
        for (char c: s.toCharArray()) {
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row: rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = convert("PAYPALISHIRING", 4);
    }
}
