// 2022.05.15
// Problem Statement:
// https://leetcode.com/problems/game-of-life/

// idea: calculate the sum of neighbours to see if it's live or dead
// if a live is going to be live or a dead is going to be dead, do nothing
// if a live is going to be dead, change the value to 2,
// if a dead is goinng to be live, change the value to 3
// finally revert the 2 back to 0, and the 3 back to 1
class Solution {
    public boolean isLive(int [][] board, int x, int y) {
        int sum = 0;
        // top-left
        if (x-1>=0 && y-1>=0) {
            if (board[x-1][y-1]==2) {
                sum += 1;
            } else if (board[x-1][y-1]==3) {
                sum += 0;
            } else {
                sum += board[x-1][y-1];
            }
        }
        // top
        if (x-1>=0) {
            if (board[x-1][y]==2) {
                sum += 1;
            } else if (board[x-1][y]==3) {
                sum += 0;
            } else {
                sum += board[x-1][y];
            }
        }
        // top-right
        if (x-1>=0 && y+1<=board[0].length-1) {
            if (board[x-1][y+1]==2) {
                sum += 1;
            } else if (board[x-1][y+1]==3) {
                sum += 0;
            } else {
                sum += board[x-1][y+1];
            }
        }
        // left
        if (y-1>=0) {
            if (board[x][y-1]==2) {
                sum += 1;
            } else if (board[x][y-1]==3) {
                sum += 0;
            } else {
                sum += board[x][y-1];
            }
        }
        // right
        if (y+1<=board[0].length-1) {
            if (board[x][y+1]==2) {
                sum += 1;
            } else if (board[x][y+1]==3) {
                sum += 0;
            } else {
                sum += board[x][y+1];
            }
        }
        // bottom-left
        if (x+1<=board.length-1 && y-1>=0) {
            if (board[x+1][y-1]==2) {
                sum += 1;
            } else if (board[x+1][y-1]==3) {
                sum += 0;
            } else {
                sum += board[x+1][y-1];
            }
        }
        // bottom
        if (x+1<=board.length-1) {
            if (board[x+1][y]==2) {
                sum += 1;
            } else if (board[x+1][y]==3) {
                sum += 0;
            } else {
                sum += board[x+1][y];
            }
        }
        // bottom-right
        if (x+1<=board.length-1 && y+1<=board[0].length-1) {
            if (board[x+1][y+1]==2) {
                sum += 1;
            } else if (board[x+1][y+1]==3) {
                sum += 0;
            } else {
                sum += board[x+1][y+1];
            }
        }
        
        if (board[x][y] == 1) {
            if (sum<=1 || sum>=4) {
                return false;
            }
            return true;
        } else {
            if (sum==3) {
                return true;
            }
            return false;
        }
    }
    
    public void gameOfLife(int[][] board) {
        for (int x=0; x<board.length; x++) {
            for (int y=0; y<board[0].length; y++) {
                boolean is_live = isLive(board, x, y);
                if (board[x][y]==1 && !is_live) {
                    board[x][y] = 2;
                } else if (board[x][y]==0 && is_live) {
                    board[x][y] = 3;
                }
            }
        }
        
        for (int x=0; x<board.length; x++) {
            for (int y=0; y<board[0].length; y++) {
                if (board[x][y]==2) {
                    board[x][y] = 0;
                } else if (board[x][y]==3) {
                    board[x][y] = 1;
                }
            }
        }
        return;
    }
}