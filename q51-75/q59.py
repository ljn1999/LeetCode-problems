# 2020.08.27
# again, I'm having a busy week :-(
# Problem Statement:
# https://leetcode.com/problems/spiral-matrix-ii/
# definitely need to polish up, but not going to do it today.

class Solution:
    def generateMatrixHelper(self, answer, start_num, start_x, start_y, n):
        # only one number to fill in
        if start_num == n**2:
            answer[start_x][start_y] = n**2
            return n**2
        
        # up row
        for i in range(start_y, n-start_y-1):
            answer[start_x][i] = start_num
            start_num = start_num + 1
        
        # right col
        for i in range(start_x, n-start_x-1):
            answer[i][n-start_y-1] = start_num
            start_num = start_num + 1
        
        # bottom row
        for i in reversed(range(start_y+1, n-start_y)):
            answer[n-start_x-1][i] = start_num
            start_num = start_num + 1

        # left col
        for i in reversed(range(start_x+1, n-start_x)):
            answer[i][start_y] = start_num
            start_num = start_num + 1
            
        return start_num-1
            
                             
    def generateMatrix(self, n: int) -> List[List[int]]:
        # check empty case
        if n == 0: return []
        
        # initialize answer to return to all zeros
        answer = []
        for i in range(0, n):
            temp = []
            for j in range(0, n):
                temp.append(0)
            answer.append(temp)
        
        # start_x, start_y are the positions of the particular round to be operated on
        # start_num and end_num are the min and max nums to be filled in that round (can actually be combined)
        start_x, start_y = 0, 0
        start_num, end_num = 0, 0
        
        # while not finished the last element
        while end_num < n**2:            
            start_num = end_num + 1
            # call helper function and fill in elements
            end_num = self.generateMatrixHelper(answer, start_num, start_x, start_y, n)
            # increase x and y position
            start_x = start_x + 1
            start_y = start_y + 1
        
        return answer