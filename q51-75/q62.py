# 2020.08.30
# Problem Statement:
# https://leetcode.com/problems/unique-paths/

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # check corner cases and do early return
        if m == 1 or n == 1: return 1
        
        # initialize answer to return
        answer = [[0 for i in range(m)] for j in range(n)]

        # fill it line by line
        for i in range(0, n):
            for j in range(0, m):
                if i == 0 or j == 0: 
                    answer[i][j] = 1
                else:
                    answer[i][j] = answer[i][j-1] + answer[i-1][j]
                
        return answer[n-1][m-1]
                