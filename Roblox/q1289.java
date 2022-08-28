// 2022.08.28
// Problem Statement:
// https://leetcode.com/problems/minimum-falling-path-sum-ii/

// idea: use dp to store the min path to the bottom
class Solution {
    public int minFallingPathSum(int[][] grid) {
        // dp[i][j] = grid[i][j] + min(dp[i+1][x]) for all x in [0, n-1] expect j
        int [][] dp = new int [grid.length][grid[0].length];
        for (int i=grid.length-1; i>=0; i--) {
            for (int j=0; j<grid[0].length; j++) {
                if (i==grid.length-1) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = grid[i][j];
                    int min_val = Integer.MAX_VALUE;
                    for (int x=0; x<grid[0].length; x++) {
                        if (x!=j) {
                            min_val = Math.min(min_val, dp[i+1][x]);
                        }
                    }
                    dp[i][j] += min_val;
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int col=0; col<grid[0].length; col++) {
            answer = Math.min(answer, dp[0][col]);
        }
        return answer;
    }
}