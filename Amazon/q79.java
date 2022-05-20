// 2022.05.20 midnight
// Problem Statement:
// https://leetcode.com/problems/word-search/

// idea: dfs
// can modify the board[x][y] to * to mark a visited node, instead of building a whole new structure
class Solution {
    boolean [][] visited;
    public boolean existHelper(char[][] board, String word, int x, int y) {
        if (word.length()==0) return true;
        if (word.charAt(0)!=board[x][y]) return false;
        if (word.length()==1 && word.charAt(0)==board[x][y]) return true;
        visited[x][y] = true;
        boolean temp = false;
        // top
        if (x>0 && !visited[x-1][y]) {
            temp = existHelper(board, word.substring(1), x-1, y);
            if (temp) return true;
        }
        // left
        if (y>0 && !visited[x][y-1]) {
            temp = existHelper(board, word.substring(1), x, y-1);
            if (temp) return true;
        }
        // bottom
        if (x<board.length-1 && !visited[x+1][y]) {
            temp = existHelper(board, word.substring(1), x+1, y);
            if (temp) return true;
        }
        // right
        if (y<board[0].length-1 && !visited[x][y+1]) {
            temp = existHelper(board, word.substring(1), x, y+1);
            if (temp) return true;
        }
        visited[x][y] = false;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        // dfs
        boolean answer = false;
        visited = new boolean [board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                answer = existHelper(board, word, i, j);
                if (answer) return true;
            }
        }
        return false;
    }
}