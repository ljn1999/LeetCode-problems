# 2020.08.17
# finished yesterday but uploaded today lol.
# Problem Statement:
# https://leetcode.com/problems/rotate-image/

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)

        # idea:
        # each element in matrix can be grouped with 3 other elements,
        # their values should be switched once and only once.

        # inside each group, the element positions should be:
        # 1. i, j
        # 2. j, n-1-i
        # 3. n-1-i, n-1-j
        # 4. n-1-j, i
        
        # this way of loop (from the outside to the inside) 
        # makes sure the values are switched in group of 4 once and only once.
        for i in range(0, int(n/2)):
            for j in range(i, len(matrix)-i-1):
                temp = matrix[i][j]
                matrix[i][j] = matrix[n-1-j][i] # 4->1
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j] # 3->4
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i] # 2->3
                matrix[j][n-1-i] = temp # 1->2
                