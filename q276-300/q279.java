// 2022.05.13
// Problem Statement:
// https://leetcode.com/problems/perfect-squares/

// idea: dp in a more clever way
class Solution {
    public int numSquares(int n) {
        // dp[i] = min(1+dp[i-k^2]), k in [1, sqrt(i)]
        int [] dp = new int [n+1];
        dp[0] = 0;
        for (int i=1; i<=n; i++) {
            double sq = Math.sqrt(i); 
            if ((sq - Math.floor(sq)) == 0) {
                dp[i] = 1;
            } else {
                int curr_min = n;
                for (int j=1; j<Math.sqrt(i); j++) { // don't need to consider all j in [1, n-1]
                    curr_min = Math.min(curr_min, 1+dp[i-j*j]);
                }
                dp[i] = curr_min;
            }
        }
        return dp[n];
    }
}