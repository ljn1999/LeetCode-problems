# 2020.03.18
# Problem Statement:
# https://leetcode.com/problems/word-break-ii/

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        # almost the same as the previous question, I don't get why it could beat over 90% ...
        # dp
        self.dp_structure = [[[] for i in range(len(s)+1)] for j in range(len(s)+1)]
        wordDict = set(wordDict)
        # order: from shortest substring to longest, therefore all info needed for current step is already calculated
        for length in range(1, len(s)+1):
            for start in range(0, len(s)+1-length):
                end = start+length

                # if substring itself is in wordDict
                if s[start:end] in wordDict:
                    self.dp_structure[start][end].append(s[start:end])

                # check for combination    
                for middle in range(start+1, end):
                    left = self.dp_structure[start][middle]
                    right = self.dp_structure[middle][end]
                    
                    if len(left)!=0 and len(right)!=0:
                        for left_element in left:
                            for right_element in right:
                                # check to ensure no duplications. very important!                                
                                if (left_element+" "+right_element) not in self.dp_structure[start][end]:
                                    self.dp_structure[start][end].append(left_element+" "+right_element)

        return self.dp_structure[0][len(s)]
        
    