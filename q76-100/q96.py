# 2020.01.04
# Problem Statement:
# https://leetcode.com/problems/unique-binary-search-trees/

import numpy as np

# version 1: # the same idea as the last question, added a dp structure for faster speed
class Solution:    
    def numTreesHelper(self, start, end):
        # initialize answer to return
        num = 0
        
        # what really matters about the number is the difference
        # eg: if 1-3 has 5 binary trees, 4-6 should has 5 binary trees as well
        difference = end - start

        # base case: can only form one kind of tree
        if difference <= 0:
            num = 1
        
        # already calculated, directly return
        elif self.dp_structure[difference] != 0:
            return self.dp_structure[difference]

        # should do the calculation
        else: 
            for i in range(start, end+1):
                left_num = self.numTreesHelper(start, i-1)
                right_num = self.numTreesHelper(i+1, end)
                num = num + left_num * right_num
                # fill in the dp structure
                self.dp_structure[difference] = num
            
        return num   
    
    def numTrees(self, n: int) -> int:
        self.dp_structure = np.zeros(n)
        return int(self.numTreesHelper(1, n))


############################################################
# version 2: idea is the same as version 1, but more generalized
# the answer for n would always equal to the sum of products of all 2-number combinations which add up to n-1
# eg: answer(7) = answer(0)*answer(6) + answer(1)*answer(5) + answer(2)*answer(4) + answer(3)*answer(3)
#               + answer(4)*answer(2) + answer(5)*answer(1) + answer(6)*answer(0)
# half of them do not to be calculated twice, but actually will not take much time because of the early return
# v2 is still slow, but it's the best I could think of :-(
import numpy as np
class Solution:
    def numTreesHelper(self, n):
        # already calculated, directly return
        if self.dp_structure[n] != 0: return self.dp_structure[n] 
        
        num = 0
        for i in range(n):
            num = num + self.numTreesHelper(i) * self.numTreesHelper(n-1-i) 

        ''' # alternatively: save half loop but not much faster
        if n % 2 == 1:            
            for i in range((n-1)//2):
                num = num + self.numTreesHelper(i) * self.numTreesHelper(n-1-i) 
            num = 2*num + self.numTreesHelper(n//2)**2
        else:
            for i in range(n//2):
                num = num + self.numTreesHelper(i) * self.numTreesHelper(n-1-i)
            num = 2*num
        '''

        self.dp_structure[n] = num
        return num    
    
    def numTrees(self, n: int) -> int:
        self.dp_structure = np.zeros(n+1)
        # base cases
        self.dp_structure[0] = 1
        self.dp_structure[1] = 1        
        return int(self.numTreesHelper(n))