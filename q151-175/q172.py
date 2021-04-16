# 2021.04.15
# Problem Statement:
# https://leetcode.com/problems/factorial-trailing-zeroes/

import math
class Solution:
    def trailingZeroes(self, n: int) -> int:
        # it's basically a math problem
        # the number of trailing zeros is determined by min(number of components of 5, number of components of 2)
        # for factorial numbers, number of components of 5 would be larger than number of components of 2
        # eg: if decompose n into products of primary numbers, n = 2^x_2 * 5^x_5 * other primary numbers, x_2 always >= x_5
        
        # check corner case
        if n == 0: return 0
        
        # calculate x_5
        number_of_5 = 0
        for i in range(1, int(math.log(n, 5))+1):
            number_of_5 = number_of_5 + n // 5**i
        
        return number_of_5