# 2020.08.22
# Problem Statement:
# https://leetcode.com/problems/spiral-matrix/

class Solution:
    # helper function for appending each round
    def spiralOrderHelper(self, matrix, start_row, start_col, answer):
        
        # if only contains a row, append the row
        if start_row+1 == len(matrix) - start_row: 
            for i in range(start_col, len(matrix[0]) - start_col):
                answer.append(matrix[start_row][i])
            return answer
        
        # if only contains a col, append the col
        elif start_col+1 == len(matrix[0]) - start_col:
            for i in range(start_row, len(matrix) - start_row):
                answer.append(matrix[i][start_col])
            return answer
        
        # otherwise
        # append the top row
        for i in range(start_col, len(matrix[0]) - start_col):
            answer.append(matrix[start_row][i])
        
        # append the right col
        for i in range(start_row+1, len(matrix) - start_row):
            answer.append(matrix[i][len(matrix[0]) - start_col - 1])
        
        # append the bottom row
        for i in range(start_col+1, len(matrix[0]) - start_col):
            answer.append(matrix[len(matrix) - start_row - 1][len(matrix[0])-1-i])

        # append the left col    
        for i in range(start_row+1, len(matrix) - start_row - 1):
            answer.append(matrix[len(matrix)-1-i][start_col])
        
        return answer
        
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # check empty case
        if matrix == []: return []
        
        # initialize answer to return, and the top-left position of a round
        answer = []
        row, col = 0, 0
        
        # should not go beyond min(len(matrix[0])-1, len(matrix)-1) to avoid duplication
        x = min(len(matrix[0])-1, len(matrix)-1)
        while row <= x // 2:
            answer = self.spiralOrderHelper(matrix, row, col, answer)
            row = row + 1
            col = col + 1
        return answer
        