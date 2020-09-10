# 2020.09.10
# Problem Statement:
# https://leetcode.com/problems/search-a-2d-matrix/

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # check empty cases
        if len(matrix) == 0: return False
        if len(matrix[0]) == 0: return False
        
        # do binary search, find row first, then col (if exists)
        # find the potential row index
        low_row = 0
        high_row = len(matrix)
        row = int(1/2 * (low_row+high_row))
        # binary search begins
        while True:
            if matrix[0][0] > target: return False
            elif matrix[row][0] == target: return True
            elif matrix[row][0] > target:
                # search to smaller rows
                high_row = row
                row = int(1/2 * (low_row+high_row))
            elif row == len(matrix)-1: break
            elif matrix[row][0] < target and matrix[row+1][0] > target: break
            else:
                # search to larger rows
                low_row = row
                row = int(1/2 * (low_row+high_row))

        # find the potential col index        
        low_col = 0
        high_col = len(matrix[0])
        col = int(1/2 * (low_col+high_col))
        
        # early return if not possible in this row
        if matrix[row][-1] < target: return False
        # binary search begins
        while True:
            if matrix[row][col] == target: return True
            elif matrix[row][col] < target and matrix[row][col+1] > target: return False
            elif matrix[row][col] < target:
                # search to the right
                low_col = col
                col = int(1/2 * (low_col+high_col))
            else:
                # search to the left
                high_col = col
                col = int(1/2 * (low_col+high_col))
        
        
        
        