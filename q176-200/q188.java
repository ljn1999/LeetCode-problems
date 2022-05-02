// 2022.05.02
// Problem Statement:
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

// Referred to the discussion page.
// idea: dp, dp[day][tran] = max(do nothing, make a transaction (sell) at that day)
// do nothing: dp[day-1][tran]
// make a transaction = max(dp[x][tran-1]+prices[day]-prices[x]), 0 <= x <= day-1
// base case: when day=0 or transaction=0, dp value = 0
class Solution {
    public int maxProfit(int k, int[] prices) {

        if (k==0 || prices.length==0) return 0;
        int [][] dp = new int [prices.length][k+1];
        // dp[0][j] = 0 no price
        // dp[i][0] = 0 no buy/sell
        for (int i=0; i<prices.length; i++) {
            dp[i][0] = 0;
        }
        for (int j=0; j<k+1; j++) {
            dp[0][j] = 0;
        }
        
        for (int i=1; i<prices.length; i++) {
            for (int j=1; j<k+1; j++) {
                int tran_max = 0;
                for (int x=0; x<=i-1; x++) {
                    tran_max = Math.max(tran_max, prices[i]-prices[x]+dp[x][j-1]);
                }
                dp[i][j] = Math.max(dp[i-1][j], tran_max);
            }
        }
        return dp[prices.length-1][k];
    }
}