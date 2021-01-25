# 2020.01.24
# Problem Statement:
# https://leetcode.com/problems/pascals-triangle/

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        # in row number i, the element number j should be
        # 1, if it's the first or the last in row n
        # element number j-1 + element number j in row n-1, otherwise
        
        if numRows == 0: return []
        answer = []
        for i in range(0, numRows):
            row_answer = []
            for j in range(0, i+1):
                if j == 0 or j == i:
                    row_answer.append(1)
                else:
                    row_answer.append(answer[i-1][j-1] + answer[i-1][j])            
            answer.append(row_answer)
        
        return answer