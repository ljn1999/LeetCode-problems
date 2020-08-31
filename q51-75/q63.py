# 2020.08.30
# maybe won't do leetcode tomorrow
# Problem Statement:
# https://leetcode.com/problems/unique-paths-ii/

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid[0])
        n = len(obstacleGrid)
        
        # check corner cases and do early return
        if m == 1 or n == 1:
            s = 0
            for i in range(0, n):
                for j in range(0, m):
                    if obstacleGrid[i][j] == 1:
                        return 0
            return 1
        
        # initialize the answer
        answer = [[0 for i in range(m)] for j in range(n)]

        # do it line by line
        for i in range(0, n):
            for j in range(0, m):
                # can not reach the obstacle, therefore 0 is filled in
                if obstacleGrid[i][j] == 1:
                    answer[i][j] = 0
                # side values, depend on their neighbour
                elif (i == 0 and j == 0) or \
                     (i == 0 and j>=1 and answer[0][j-1] != 0) or \
                     (j == 0 and i>=1 and answer[i-1][j] != 0): 
                    answer[i][j] = 1
                else:
                    answer[i][j] = answer[i][j-1] + answer[i-1][j]
                
        return answer[n-1][m-1]