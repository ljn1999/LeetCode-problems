# 2020.02.09
# Problem Statement:
# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

# I still remember this is exactly the first question I got in my interview with Intel. I did it pretty bad. I was, and I still am such a loser :-(
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # initialize buy and sell day and profit
        buy_day, sell_day, profit = 0, 0, 0

        for i in range(0, len(prices)):
            # the larger value of price would contribute to more profit with the current buy day, but not necessarily an overall larger profit
            if prices[i] > prices[sell_day]:
                sell_day = i
                profit = max(profit, prices[i] - prices[buy_day])
            
            # the smaller value could be the new buy day, but the sell day should be changed accordingly
            elif prices[i] < prices[buy_day]:
                sell_day, buy_day = i, i
            
        return profit