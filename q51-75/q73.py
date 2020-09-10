# 2020.09.10
# Problem Statement:
# https://leetcode.com/problems/set-matrix-zeroes/
# didn't come up with an O(1) solution, looked up the discussion below:
# https://leetcode.com/problems/set-matrix-zeroes/discuss/26026/O(1)-space-solution-in-Python

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m = len(matrix) # number of rows
        n = len(matrix[0]) # number of cols
        
        for i in range(0, m):
            for j in range(0, n):
                if matrix[i][j] == 0:
                    # should not set to 0, set to other chars instead!
                    # rows
                    for x in range(0, n):
                        if matrix[i][x] != 0:
                            matrix[i][x] = "."
                    # cols        
                    for y in range(0, m):
                        if matrix[y][j] != 0:
                            matrix[y][j] = "."
                                        
        # set the dots back to 0s           
        for i in range(0, m):
            for j in range(0, n):
                if matrix[i][j] == ".":
                    matrix[i][j] = 0
                    
                    
        