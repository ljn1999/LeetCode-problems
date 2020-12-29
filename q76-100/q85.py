# 2020.12.29
# Glad to be back!
# Problem Statement:
# https://leetcode.com/problems/maximal-rectangle/
# looked up a solution from:
# https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution

import numpy as np

class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        # increment by row

        # height[i][j] stores number of continuous 1s up from position (i, j)
        # left[i][j] stores the left boundary of the continuous 1s which can certainly
        # make up a rectangle along with matrix[i][j] with height = height[i][j]
        # similarly, right[i][j] stores the right boundary of the continuous 1s which can certainly
        # make up a rectangle along with matrix[i][j] with height = height[i][j]
        
        # check corner cases
        if len(matrix) == 0 or len(matrix[0]) == 0: return 0
        
        # initialize the data structures
        height = np.zeros([len(matrix), len(matrix[0])])
        left = np.zeros([len(matrix), len(matrix[0])])
        right = np.zeros([len(matrix), len(matrix[0])])
               
        max_area = 0
        
        # iterate rows and columns
        for i in range(0, len(matrix)):
            
            # initialize left and right boundaries
            left_boundary, right_boundary = 0, len(matrix[0])-1

            for j in range(0, len(matrix[0])):
                
                # fill in the values in "height" and "left"
                if matrix[i][j] == "1":
                    if i >= 1:
                        height[i][j] = height[i-1][j] + 1
                        left[i][j] = max(left[i-1][j], left_boundary)
                    else:
                        height[i][j] = 1
                        left[i][j] = left_boundary                    
                else:
                    height[i][j] = 0
                    left_boundary = j + 1
                
                # fill in the values in "right"
                if matrix[i][len(matrix[0])-1-j] == "1":
                    if i>= 1:
                        right[i][len(matrix[0])-1-j] = min(right[i-1][len(matrix[0])-1-j], right_boundary)
                    else:
                        right[i][len(matrix[0])-1-j] = right_boundary
                else:
                    right[i][len(matrix[0])-1-j] = len(matrix[0])-1
                    right_boundary = len(matrix[0])-1-j - 1
        
        # calculate the max area
        for i in range(0, len(matrix)):
            for j in range(0, len(matrix[0])):
                max_area = max(max_area, height[i][j] * (right[i][j]-left[i][j]+1))
        
        #print(height)
        #print(left)
        #print(right)        
        
        return int(max_area)
                
