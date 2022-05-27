// 2022.05.27
// Problem Statement:
// https://leetcode.com/problems/dungeon-game/

// idea: dp, as stated in the comment
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // 3 requirements:
        // dp[i][j] >= 1
        // dp[i][j] + dungeon[i][j] >= 1
        // dp[i][j] + dungeon[i][j] >= min(dp[i+1][j], dp[i][j+1]) larger than min(right, bottom)
        max(1-dungeon[i][j], min(-dungeon[i][j] + dp[i+1][j], -dungeon[i][j] + dp[i][j+1]))
        int m = dungeon.length, n = dungeon[0].length;
        int [][] dp = new int [m][n]; // stores the health before entering cell dungeon[i][j]
        dp[m-1][n-1] = Math.max(1, 1-dungeon[m-1][n-1]);
        for (int i=m-2; i>=0; i--) {
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
        }
        for (int i=n-2; i>=0; i--) {
            dp[m-1][i] = Math.max(1, dp[m-1][i+1] - dungeon[m-1][i]);
        }
        for (int i=m-2; i>=0; i--) {
            for (int j=n-2; j>=0; j--) {
                dp[i][j] = Math.max(1, -dungeon[i][j]+Math.max(1, Math.min(dp[i+1][j], dp[i][j+1])));
            }
        }
        return dp[0][0];
    }
}