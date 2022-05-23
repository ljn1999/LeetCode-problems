// 2022.05.23 midnight
// Problem Statement:
// https://leetcode.com/problems/max-area-of-island/

// idea: dfs, reverse 1 to 0 after visiting it
class Solution {
    public int maxAreaOfIslandHelper(int[][] grid, int x_pos, int y_pos) {
        if (grid[x_pos][y_pos]==0) return 0;
        int area = 1;
        grid[x_pos][y_pos]=0;
        // top
        if (x_pos>0) {
            area += maxAreaOfIslandHelper(grid, x_pos-1, y_pos);
        }
        // left
        if (y_pos>0) {
            area += maxAreaOfIslandHelper(grid, x_pos, y_pos-1);
        }
        // bottom
        if (x_pos<grid.length-1) {
            area += maxAreaOfIslandHelper(grid, x_pos+1, y_pos);
        }
        // right
        if (y_pos<grid[0].length-1) {
            area += maxAreaOfIslandHelper(grid, x_pos, y_pos+1);
        }
        return area;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                answer = Math.max(answer, maxAreaOfIslandHelper(grid, i, j));
            }
        }
        return answer;
    }
}