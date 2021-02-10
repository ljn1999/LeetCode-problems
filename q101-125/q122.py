# 2020.02.09
# Problem Statement:
# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        
        # if prices goes up, add up the profit
        # otherwise, do nothing
        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                profit = profit + prices[i] - prices[i-1]
        return profit
                