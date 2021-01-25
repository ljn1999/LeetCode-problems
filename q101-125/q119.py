# 2020.01.25
# Problem Statement:
# https://leetcode.com/problems/pascals-triangle-ii/

class Solution:
    def getRow(self, rowIndex: int) -> List[int]:        
        # initialization
        answer = [0]*(rowIndex+1)
        
        # constant (2) extra space
        temp, temp_prev = 0, 0
        
        for i in range(0, rowIndex+1):
            for j in range(0, i+1):                
                if j == 0 or j == i:                    
                    answer[j] = 1
                    temp_prev = 1
                else:
                    temp = answer[j]
                    answer[j] = answer[j] + temp_prev
                    temp_prev = temp              
        
        return answer