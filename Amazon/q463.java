// 2022.06.16 midnight
// Problem Statement:
// https://leetcode.com/problems/island-perimeter/

// idea: count the number of neighbours of water for each cell,
// if on the edge, treat as water
class Solution {
    public int islandPerimeter(int[][] grid) {
        int answer = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j]==1) {
                    if (i==0 || grid[i-1][j]==0) {
                        answer++;
                    }
                    if (i==grid.length-1 || grid[i+1][j]==0) {
                        answer++;
                    }
                    if (j==0 || grid[i][j-1]==0) {
                        answer++;
                    }
                    if (j==grid[0].length-1 || grid[i][j+1]==0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}