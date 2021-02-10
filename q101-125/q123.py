# 2020.02.10
# Problem Statement:
# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
# Could not think of any solution with O(n), so looked up the solution here:
# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution

import numpy as np
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # dp structure:
        # dp_structure[day i][transaction times t] = max(dp_structure[i-1][t](do nothing on day i), prices[i]-prices[j]+dp_structure[j][t-1]), where 0<=j<=i-1
        dp_structure = np.zeros((len(prices), 2))
        
        # transaction time: 1 or 2 (index 0 or 1)
        for t in range(0, 2):
            # to make prices[i] + temp = 0 initially
            temp = -prices[0]
            # iterate over all dates
            for i in range(0, len(prices)):
                # can get rid of the loop for j, since there's no need to calculate -prices[j]+dp_structure[j][t-1] everytime when a new i is used,
                # can just keep track of current largest temp
                temp = max(temp, -prices[i] + dp_structure[i][t-1])
                
                dp_structure[i][t] = max(prices[i]+temp, dp_structure[i-1][t]) # do nothing
        
        # return the last element in dp_structure
        return int(dp_structure[len(prices)-1][1])