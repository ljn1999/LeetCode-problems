# 2020.09.06
# Problem Statement:
# https://leetcode.com/problems/climbing-stairs/
# This problem was one of the questions I was given when I was interviewed by Huawei!
# How time flies! The interview was successful and I took the offer.
# I learnt a lot in the internship but I have a meeting tmr @ 10AM (tmr is a public holiday),
# so I have to say I have mixed feelings lol.

class Solution:
    def climbStairs(self, n: int) -> int:
        
        # idea: dynamic programming
        # for every n, the answer is the sum of n-1's answer and n-2's answer,
        # since for the last step you can take 1 or 2.
        # it's actually a fibonacci series.

        one_before = 1
        two_before = 1
        
        # check corner cases
        if n == 1: return 1
        
        for i in range(2, n+1):
            answer = one_before + two_before
            one_before, two_before = answer, one_before
            
        return answer