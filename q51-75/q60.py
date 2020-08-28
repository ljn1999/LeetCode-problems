# 2020.08.28
# Problem Statement:
# https://leetcode.com/problems/permutation-sequence/

import math
class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        # check empty case
        if n==0: return ""
        
        # idea: pure math
        list_n = []
        for i in range(0, n):
            list_n.append(i+1)
        
        # initialize answer to return
        answer = ""
        # add each element, from left to the right
        for i in range(0, n):
            index = (k-1) // math.factorial(n-i-1)
            k = k % math.factorial(n-i-1)
            answer = answer + str(list_n[index])
            list_n.remove(list_n[index])
            
        return answer