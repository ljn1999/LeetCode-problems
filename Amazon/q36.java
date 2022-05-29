// 2022.05.28
// Problem Statement:
// https://leetcode.com/problems/valid-sudoku/

// idea: use stack to check duplication in rows/cols/3*3 cells
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check row, col and 3*3 cells
        // row
        for (int i=0; i<9; i++) {
            HashSet<Character> row_set = new HashSet<> ();
            for (int j=0; j<9; j++) {
                if (board[i][j]!='.') {
                    if (row_set.contains(board[i][j])) return false;
                    row_set.add(board[i][j]);
                }
            }
        }
        // col
        for (int j=0; j<9; j++) {
            HashSet<Character> col_set = new HashSet<> ();
            for (int i=0; i<9; i++) {
                if (board[i][j]!='.') {
                    if (col_set.contains(board[i][j])) return false;
                    col_set.add(board[i][j]);
                }
            }
        }
        // 3*3 cells
        for (int cnt=0; cnt<9; cnt++) {
            HashSet<Character> cell_set = new HashSet<> ();
            for (int i=3*(cnt/3); i<3*(cnt/3)+3; i++) {
                for (int j=3*(cnt%3); j<3*(cnt%3)+3; j++) {
                    if (board[i][j]!='.') {
                        if (cell_set.contains(board[i][j])) return false;
                        cell_set.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}