# 2020.12.30
# Problem Statement:
# https://leetcode.com/problems/scramble-string/
# have to admit that I kind of forget about recursion, the answer below is brilliant:
# https://leetcode.com/problems/scramble-string/discuss/29392/Share-my-4ms-c%2B%2B-recursive-solution

import numpy as np
class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        # base case, when only one character
        if len(s1) == 1:
            return s1 == s2
        
        # easy check
        if s1 == s2: return True
        
        # check if character counts match
        # if not match, can not possibly return true
        count = np.zeros(26)        
        for i in range(0, len(s1)):
            count[ord(s1[i])-ord('a')] = count[ord(s1[i])-ord('a')] + 1
            count[ord(s2[i])-ord('a')] = count[ord(s2[i])-ord('a')] - 1           
        for i in range(0, 26):
            if count[i] != 0: return False
        
        # try all possibilities of dividing the substrings
        for i in range(1, len(s1)):
            # recursive call
            # can match either way, s1 left with s2 right or s1 right with s2 left
            if (self.isScramble(s1[:i], s2[:i]) and self.isScramble(s1[i:], s2[i:])) or \
            (self.isScramble(s1[:i], s2[len(s1)-i:]) and self.isScramble(s1[i:], s2[:len(s2)-i])):
                return True
            
        return False
        
            