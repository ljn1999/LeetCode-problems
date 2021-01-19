# 2020.01.19
# Problem Statement:
# https://leetcode.com/problems/distinct-subsequences/
# My answer exceeded the time limit, referred to a dp solution here:
# https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java
import numpy as np

class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        if len(s) < len(t): return 0
        if len(s) == len(t): return int(s==t)
        
        # if take this char, have numDistinct(s_without_this_char, t_without_this_char) ways
        # if not take this char, have numDistinct(s_without_this_char, t) ways
        
        self.dp_structure = np.zeros((len(s)+1, len(t)+1))
        return int(self.numDistinctHelper(s, t))
    
    def numDistinctHelper(self, s, t):
        for i in range(0, len(s)):
            self.dp_structure[i][0] = 1
        
        for i in range(0, len(s)):
            for j in range(0, len(t)):
                if s[i] != t[j]:
                    self.dp_structure[i+1][j+1] = self.dp_structure[i][j+1]
                else:
                    self.dp_structure[i+1][j+1] = self.dp_structure[i][j+1] + \
                                              self.dp_structure[i][j]
        return self.dp_structure[len(s)][len(t)]
    

# personal solution (out of time limit), actually not sure what caused the time difference
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        if len(s) < len(t): return 0
        if len(s) == len(t): return int(s==t)
        
        # if take this char, have numDistinct(s_without_this_char, t_without_this_char)
        # if not take this char, have numDistinct(s_without_this_char, t)
        
        self.dp_structure = np.zeros((len(s)+1, len(t)+1))
        return int(self.numDistinctHelper(s, t))
    
    def numDistinctHelper(self, s, t):
        if len(t) == 0: 
            self.dp_structure[len(s)][len(t)] = 1
            return 1
        if len(s) < len(t): 
            self.dp_structure[len(s)][len(t)] = 0
            return 0
        if len(s) == len(t): 
            self.dp_structure[len(s)][len(t)] = (s==t)
            return s==t
        
        if self.dp_structure[len(s)][len(t)] != 0: return self.dp_structure[len(s)][len(t)]
        
        if s[0] != t[0]:
            self.dp_structure[len(s)][len(t)] = self.numDistinctHelper(s[1:], t)
            return self.dp_structure[len(s)][len(t)]
        else:
            self.dp_structure[len(s)][len(t)] = self.numDistinctHelper(s[1:], t[1:]) \
                                              + self.numDistinctHelper(s[1:], t)
            return self.dp_structure[len(s)][len(t)]
    