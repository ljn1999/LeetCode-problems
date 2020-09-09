# 2020.09.09
# Problem Statement:
# https://leetcode.com/problems/edit-distance/
# Failed to recognize it as a dp problem, looked up a very smart solution in:
# https://leetcode.com/problems/wildcard-matching/

class Solution:
    def minDistanceHelper(self, word1, word2, word1_idx, word2_idx):
        # 3 base cases
        # finished
        if word1_idx == len(word1) and word2_idx == len(word2): 
            self.memory[(word1_idx, word2_idx)] = 0
            return 0
        # word1 is gone through, just insert the rest to word1
        if word1_idx == len(word1): 
            self.memory[(word1_idx, word2_idx)] = len(word2)-word2_idx
            return len(word2)-word2_idx
        # word2 is gone through, just delete the rest in word1
        if word2_idx == len(word2): 
            self.memory[(word1_idx, word2_idx)] = len(word1)-word1_idx
            return len(word1)-word1_idx
        
        # check if already in the dp structure
        if (word1_idx, word2_idx) in self.memory.keys():
            return self.memory[(word1_idx, word2_idx)]
        
        else:
            # the current char matches
            if word1[word1_idx] == word2[word2_idx]:
                temp1 = self.minDistanceHelper(word1, word2, word1_idx+1, word2_idx+1)
                # store the result into the dp structure
                self.memory[(word1_idx, word2_idx)] = temp1
                return temp1
            # the current char does not match, see which way optimizes the result
            else:
                insert = 1 + self.minDistanceHelper(word1, word2, word1_idx, word2_idx+1)
                delete = 1 + self.minDistanceHelper(word1, word2, word1_idx+1, word2_idx)
                replace = 1 + self.minDistanceHelper(word1, word2, word1_idx+1, word2_idx+1)
                temp2 = min(insert, delete, replace)
                # store the result into the dp structure
                self.memory[(word1_idx, word2_idx)] = temp2
                return temp2
        
        
    def minDistance(self, word1: str, word2: str) -> int:
        # initialize dp structure
        self.memory = {}
        # call helper function and do the dp       
        answer = self.minDistanceHelper(word1, word2, 0, 0)
        return answer