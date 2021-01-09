package com.checkpeng.leetcode.middle;

public class 有效的数独 {

    /**
     * 也可以使用好多个HASHMAP来解决，个人觉得没必要
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!isRowTrue(board, i, j) || !isColTrue(board, i, j) || !isSquareTrue(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 判断行上有没有相同的字符
    public boolean isRowTrue(char[][] board, int i, int j) {
        for (int k = 0; k < board.length; k++) {
            if (board[i][k] == board[i][j] && k != j) {
                return false;
            }
        }
        return true;
    }

    // 判断列上有没有相同的字符
    public boolean isColTrue(char[][] board, int i, int j) {
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == board[i][j] && k != i) {
                return false;
            }
        }
        return true;
    }

    // 判断方格内有没有相同的字符
    public boolean isSquareTrue(char[][] board, int i, int j) {
        int temp = i / 3;
        int a1 = 3 * temp;
        int a2 = 2 + 3 * temp;
        temp = j / 3;
        int b1 = 3 * temp;
        int b2 = 2 + 3 * temp;
        for (int k = a1; k <= a2; k++) {
            for (int l = b1; l <= b2; l++) {
                if (board[k][l] == board[i][j]) {
                    if (k != i || l != j) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
