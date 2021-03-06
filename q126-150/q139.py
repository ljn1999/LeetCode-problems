# 2020.03.18
# Problem Statement:
# https://leetcode.com/problems/word-break/

class Solution:
    # Approach 1, much faster, but still only faster than 5%
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # dp
        self.dp_structure = [[False for i in range(len(s)+1)] for j in range(len(s)+1)]
        wordDict = set(wordDict)
        # order: from shortest substring to longest, therefore all info needed for current step is already calculated
        for length in range(1, len(s)+1):
            for start in range(0, len(s)+1-length):
                end = start+length
                if s[start:end] in wordDict:
                    self.dp_structure[start][end] = True
                else:    
                    for middle in range(start+1, end):
                        if self.dp_structure[start][middle] and self.dp_structure[middle][end]:
                            self.dp_structure[start][end] = True
                            break
                    
        return self.dp_structure[0][len(s)]

    # Approach 2, slow dp :-(, only faster than 5%
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # dp
        # self.dp_structure[i][j] would represent if self.wordBreak(s[i:j], wordDict) is True or False
        self.dp_structure = [["x" for i in range(len(s)+1)] for j in range(len(s)+1)]
        
        # make search a bit easier (O(1) on average)
        wordDict = set(wordDict)
        
        # base case with direct return
        if s in wordDict: return True
        
        return self.wordBreakHelper(s, 0, len(s), wordDict)
    
    def wordBreakHelper(self, s, start, end, wordDict):
        # base case 1
        # if already done
        if self.dp_structure[start][end] != "x":
            return self.dp_structure[start][end]
        
        # # base case 2
        # easy check
        if s[start:end] in wordDict:
            self.dp_structure[start][end] = True
            return True
        
        answer = False
        # try out all possibilities of separation, if one of them works then return True
        for index in range(start+1, end):
            answer = answer or (self.wordBreakHelper(s, start, index, wordDict) and self.wordBreakHelper(s, index, end, wordDict))
        
        # store into the dp structure and return
        self.dp_structure[start][end] = answer
        return answer
        
        