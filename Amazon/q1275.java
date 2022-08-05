// 2022.08.05
// Problem Statement:
// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

// idea: create a board to record the moves, then do trivial if
class Solution {
    public String tictactoe(int[][] moves) {
        int [][] board = new int [3][3];
        for (int i=0; i<moves.length; i++) {
            if (i%2==0) {
                board[moves[i][0]][moves[i][1]] = 1;
            } else {
                board[moves[i][0]][moves[i][1]] = 2;
            }
        }
        // check horizontal
        for (int i=0; i<3; i++) {
            if (board[i][0]==1 && board[i][1]==1 && board[i][2]==1) return "A";
            if (board[i][0]==2 && board[i][1]==2 && board[i][2]==2) return "B";
        }
        // check vertical
        for (int i=0; i<3; i++) {
            if (board[0][i]==1 && board[1][i]==1 && board[2][i]==1) return "A";
            if (board[0][i]==2 && board[1][i]==2 && board[2][i]==2) return "B";
        }
        // check diagonal
        if (board[0][0]==1 && board[1][1]==1 && board[2][2]==1) return "A";
        if (board[0][0]==2 && board[1][1]==2 && board[2][2]==2) return "B";
        if (board[2][0]==1 && board[1][1]==1 && board[0][2]==1) return "A";
        if (board[2][0]==2 && board[1][1]==2 && board[0][2]==2) return "B";
        
        if (moves.length==9) return "Draw";
        return "Pending";
    }
}