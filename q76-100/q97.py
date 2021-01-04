# 2020.01.04
# Problem Statement:
# https://leetcode.com/problems/interleaving-string/
# Referred to the solution here:
# https://leetcode.com/problems/interleaving-string/discuss/31879/My-DP-solution-in-C%2B%2B

import numpy as np

class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        # check corner cases and do early returns
        if len(s1) == 0: return s2 == s3
        if len(s2) == 0: return s1 == s3
        if len(s1) + len(s2) != len(s3): return False

        # initialize dp structure
        # self.dp_answer[a][b] would represent if the first a elements in s1 
        # and the first b elements in s2 can form the first a+b elements in s3
        self.dp_answer = np.zeros((len(s1)+1, len(s2)+1))
        
        # start the loop
        for i in range(0, len(s1)+1):
            for j in range(0, len(s2)+1):
                # the first 0 element in s1 and first 0 element in s2 can definitely form the first 0 element in s3
                if i == 0 and j == 0:
                    self.dp_answer[i][j] = True
                elif i == 0:
                    self.dp_answer[i][j] = self.dp_answer[i][j-1] and s2[j-1] == s3[i+j-1]
                elif j == 0:
                    self.dp_answer[i][j] = self.dp_answer[i-1][j] and s1[i-1] == s3[i+j-1]
                else:
                    # the new element included can be either from s1 or s2
                    self.dp_answer[i][j] = (self.dp_answer[i][j-1] and s2[j-1] == s3[i+j-1]) or (self.dp_answer[i-1][j] and s1[i-1] == s3[i+j-1])       
        
        # return the last filled in in the dp structure
        return self.dp_answer[len(s1)][len(s2)]
        

# original version (personal solution), cannot pass some of the tests, time limit exceeded
class Solution:
    def isInterLeaveHelper(self, s1, s2, s3, take_s1):
        
        if len(s1) == 0: return s2 == s3
        if len(s2) == 0: return s1 == s3
        
        if take_s1:
            if s1[0] != s3[0]: return False
            else:
                i = 0
                while i < len(s1) and s1[i] == s3[i]:
                    i = i + 1
                
                for j in range(1, i+1):
                    self.answer = self.answer or self.isInterLeaveHelper(s1[j:], s2, s3[j:], False)
        else:
            if s2[0] != s3[0]: return False
            else:
                i = 0
                while i < len(s2) and s2[i] == s3[i]:
                    i = i +1
                
                for j in range(1, i+1):
                    self.answer = self.answer or self.isInterLeaveHelper(s1, s2[j:], s3[j:], True)
            
        return self.answer
    
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) == 0: return s2 == s3
        if len(s2) == 0: return s1 == s3
        
        if len(s1) + len(s2) != len(s3): return False
        self.answer = False
        
        return self.isInterLeaveHelper(s1, s2, s3, True) or self.isInterLeaveHelper(s1, s2, s3, False)
        
        
        