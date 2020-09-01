# 2020.09.01
# how time flies!
# Problem Statement:
# https://leetcode.com/problems/minimum-path-sum/

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        # the idea is almost the same as q62 and q63
        # correct but slow

        m = len(grid[0])
        n = len(grid)
        
        # check corner cases
        if m == 1 or n == 1:
            s = 0
            for i in range(0, n):
                for j in range(0, m):
                    s = s + grid[i][j]                    
            return s
        
        answer = [[0 for i in range(m)] for j in range(n)]

        for i in range(0, n):
            for j in range(0, m):
                # set up the top-left
                if i == 0 and j == 0:
                    answer[i][j] = grid[0][0]
                # set up the top side
                elif i == 0:
                    answer[i][j] = answer[i][j-1] + grid[i][j]
                # set up the left side
                elif j == 0:
                    answer[i][j] = answer[i-1][j] + grid[i][j]
                # fill in the else
                else:
                    answer[i][j] = min(answer[i-1][j], answer[i][j-1]) + grid[i][j]
                
        return answer[n-1][m-1]