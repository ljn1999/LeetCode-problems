// 2022.06.02
// Problem Statement:
// https://leetcode.com/problems/unique-paths-ii/

// idea: dp, from destination to start point
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] dp = new int [obstacleGrid.length][obstacleGrid[0].length];
        // base case vertical
        for (int i=obstacleGrid.length-1; i>=0; i--) {
            if (obstacleGrid[i][obstacleGrid[0].length-1]==1) {
                dp[i][obstacleGrid[0].length-1] = 0;
            } else if (i<obstacleGrid.length-1 && dp[i+1][obstacleGrid[0].length-1]==0) {
                dp[i][obstacleGrid[0].length-1] = 0;
            } else {
                dp[i][obstacleGrid[0].length-1] = 1;
            }
        }
        // base case horizontal
        for (int i=obstacleGrid[0].length-1; i>=0; i--) {
            if (obstacleGrid[obstacleGrid.length-1][i]==1) {
                dp[obstacleGrid.length-1][i] = 0;
            } else if (i<obstacleGrid[0].length-1 && dp[obstacleGrid.length-1][i+1]==0) {
                dp[obstacleGrid.length-1][i] = 0;
            } else {
                dp[obstacleGrid.length-1][i] = 1;
            }
        }
        
        for (int i=obstacleGrid.length-2; i>=0; i--) {
            for (int j=obstacleGrid[0].length-2; j>=0; j--) {
                if (obstacleGrid[i][j]==1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}