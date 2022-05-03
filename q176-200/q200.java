// 2022.05.03 midnight
// Problem Statement:
// https://leetcode.com/problems/number-of-islands/

// idea: dfs to search the complete island, 
// mark nodes as read (1->0) after reaching it
class Solution {
    public void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        if (j>0) { // left
            dfs(grid, i, j-1);
        }
        if (j<grid[0].length-1) { // right
            dfs(grid, i, j+1);
        }
        if (i>0) { // up
            dfs(grid, i-1, j);
        }
        if (i<grid.length-1) { // bottom
            dfs(grid, i+1, j);
        }
    }
    
    public int numIslands(char[][] grid) {
        int answer = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j]=='1') {
                    dfs(grid, i, j);
                    answer = answer+1; // finish one complete island
                }
            }
        }
        return answer;
    }
}