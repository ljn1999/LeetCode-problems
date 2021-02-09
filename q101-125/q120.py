# 2020.02.09
# Sorry for being away for 2 weeks. Was not really in the mood. Also I was trying to work on something else, which doesn't seem to be promising :-(
# Problem Statement:
# https://leetcode.com/problems/triangle/

import numpy as np
class Solution:
    # Solution 1: more concise, a bit faster
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle) == 0: return 0        
        dp_structure = np.zeros((len(triangle), len(triangle[-1])))
        # from bottom to up
        for i in range(0, len(triangle)):
            for j in range(0, len(triangle)-i):
                if i == 0:
                    dp_structure[len(triangle)-1-i][j] = triangle[len(triangle)-1-i][j]
                else:
                    dp_structure[len(triangle)-1-i][j] = triangle[len(triangle)-1-i][j] + \
                    min(dp_structure[len(triangle)-i][j], dp_structure[len(triangle)-i][j+1])
        return int(dp_structure[0][0])


    # Solution 2: the first one I came up with, a bit slower
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle) == 0: return 0

        # initialize dp structure
        self.dp_structure = np.zeros((len(triangle), len(triangle[-1])))
        for i in range(0, len(triangle)):
            for j in range(0, len(triangle[-1])):
                self.dp_structure[i][j] = inf
        
        return int(self.minimumTotalHelper(triangle, 0))
        
    def minimumTotalHelper(self, triangle, index):
        # check if already calculated
        if self.dp_structure[len(triangle)-1][index] != inf:
            return self.dp_structure[len(triangle)-1][index]
        else:
            # check if already reached the bottom
            if len(triangle) == 1:
                if len(triangle[0]) == 1:
                    return triangle[0][0]
                else:
                    return min(triangle[0][index], triangle[0][index]+1)
            
            temp = min(self.minimumTotalHelper(triangle[1:], index), \
                       self.minimumTotalHelper(triangle[1:], index+1))    
            
            sum = triangle[0][index] + temp
            # store in the dp structure
            self.dp_structure[len(triangle)-1][index] = sum
            return sum