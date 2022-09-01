// 2022.09.01
// Problem Statement:
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// idea: each new day after day one could be the sell day (update answer) or the buy day (update curr buy day)
class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int curr_buy_day = 0;
        for (int i=1; i<prices.length; i++) {
            // could be the sell day
            answer = Math.max(answer, prices[i]-prices[curr_buy_day]);
            
            // could be the buy day
            if (prices[i]<=prices[curr_buy_day]) {
                curr_buy_day = i;
            }
        }
        return answer;
    }
}