package com.quxun.algorithms;

/**
 * Description:37.Sudoku Solver https://leetcode-cn.com/problems/sudoku-solver/description/
 * Created by quxiaozha on 2018-9-28 14:34.
 */
public class SudokuSolver {
    private static int which(int i, int j) {
        if (i <= 2) {
            if (j <= 2)
                return 1;
            if (j <= 5)
                return 2;
            return 3;
        }
        if (i <= 5) {
            if (j <= 2)
                return 4;
            if (j <= 5)
                return 5;
            return 6;
        }
        if (j <= 2)
            return 7;
        if (j <= 5)
            return 8;
        return 9;
    }

    public static void solveSudoku(char[][] board) {
        // 3X3
        int[][] k = new int[10][10];
        // heng
        int[][] p = new int[10][10];
        // shu
        int[][] q = new int[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    p[i][board[i][j] - '0'] = 1;
                    q[j][board[i][j] - '0'] = 1;
                    k[which(i, j)][board[i][j] - '0'] = 1;
                }
            }
        }

        dfs(k, p, q, board, 0, 0);
    }

    private static boolean dfs(int[][] k, int[][] p, int[][] q, char[][] board, int i, int j) {
        if (j == 9) return true;
        if (board[i][j] != '.') {
            if (i + 1 < 9) {
                boolean rst = dfs(k, p, q, board, i + 1, j);
                if (rst) {
                    return true;
                }
            } else {
                boolean rst = dfs(k, p, q, board, 0, j + 1);
                if (rst) {
                    return true;
                }
            }
        } else {
            for (int x = 1; x <= 9; x++) {
                if (p[i][x] != 1 && q[j][x] != 1 && k[which(i, j)][x] != 1) {
                    p[i][x] = 1;
                    q[j][x] = 1;
                    k[which(i, j)][x] = 1;
                    board[i][j] = (char) (x + '0');
                    if (i + 1 < 9) {
                        boolean rst = dfs(k, p, q, board, i + 1, j);
                        if (rst) {
                            return true;
                        }
                    } else {
                        boolean rst = dfs(k, p, q, board, 0, j + 1);
                        if (rst) {
                            return true;
                        }
                    }
                    p[i][x] = 0;
                    q[j][x] = 0;
                    k[which(i, j)][x] = 0;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    static boolean[][] row = new boolean[9][9];
    static boolean[][] col = new boolean[9][9];
    static boolean[][] subBox = new boolean[9][9];
    public static void solveSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num - 1] = true;
                    col[j][num - 1] = true;
                    subBox[i / 3 * 3 + j / 3][num - 1] = true;
                }
            }
        }
        fillSudoku(0, 0, board);
    }

    private static boolean fillSudoku(int i, int j, char[][] board) {
        if (i == 9) {
            return true;
        }
        int x = j == 8 ? i + 1 : i;
        int y = j == 8 ? 0 : j + 1;
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                if (!row[i][k - 1] && !col[j][k - 1] && !subBox[i / 3 * 3 + j / 3][k - 1]) {
                    row[i][k - 1] = true;
                    col[j][k - 1] = true;
                    subBox[i / 3 * 3 + j / 3][k - 1] = true;
                    if (fillSudoku(x, y, board)) {
                        board[i][j] = (char) ('0' + k);
                        return true;
                    }
                    row[i][k - 1] = false;
                    col[j][k - 1] = false;
                    subBox[i / 3 * 3 + j / 3][k - 1] = false;
                }
            }
            return false;
        } else {
            return fillSudoku(x, y, board);
        }
    }

    public static void main(String[] args) {
        char[][] chars = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        char[][] chars2 = {{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        solveSudoku2(chars2);
        for (char[] chars1 : chars2) {
            System.out.println(chars1);
        }
    }

}
