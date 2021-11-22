package com.claus.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode_36_Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {
        // 记录数字在行中出现的次数
        int[][] rows = new int[9][9];
        // 记录数字在列中出现的次数
        int[][] cols = new int[9][9];
        // 记录数字在3X3格内出现的次数
        int[][][] boxs = new int[3][3][9];

        for (int i=0; i < 9; i++) {
            for (int j=0; j < 9; j++) {
                char c = board[i][j];

                if (c != '.') {
                    int index = c - '0' - 1;
                    // 当前行，这个数字出现次数+1
                    rows[i][index] += 1;
                    // 当前列，这个数字出现次数+1
                    cols[j][index] += 1;
                    // 当前3X3格子内，这个数字出现次数+1
                    boxs[i/3][j/3][index] += 1;

                    // 如果出现次数>1，说明重复
                    if (rows[i][index] > 1 || cols[j][index] > 1 || boxs[i/3][j/3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku_hash(char[][] board) {
        Map<Integer, Set<Integer>> row  = new HashMap<>(), col = new HashMap<>(), area = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int u = c - '0';
                int idx = i / 3 * 3 + j / 3; // 计算归属到哪一个3x3格子中
                if (row.get(i).contains(u) || col.get(j).contains(u) || area.get(idx).contains(u)) return false;
                row.get(i).add(u);
                col.get(j).add(u);
                area.get(idx).add(u);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode_36_Valid_Sudoku s = new leetcode_36_Valid_Sudoku();
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean res = s.isValidSudoku_hash(board);
    }
}
